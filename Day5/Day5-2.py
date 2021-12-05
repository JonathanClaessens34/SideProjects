def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()
    maxX_Y = getLargestXandY(inputData)
    maxX = maxX_Y[0]
    maxY = maxX_Y[1]
    occurenceArray = generate0Array(maxX, maxY)
    getAllOccurences(occurenceArray, inputData)
    print(getOccurencesAtleast2(occurenceArray))


def getOccurencesAtleast2(occurences):
    result = 0
    for i in occurences:
        for j in i:
            if j >= 2:
                result += 1
    return result


def getAllOccurences(occurences, inputData):
    for i in inputData:
        point1 = i.split(" -> ")[0]
        point2 = i.split(" -> ")[1]
        point1X = int(point1.split(",")[0])  # 6, 5
        point1Y = int(point1.split(",")[1])
        point2X = int(point2.split(",")[0])  # 3, 5
        point2Y = int(point2.split(",")[1])
        # Vertical lines
        if point1Y == point2Y and point1X != point2X:
            if point1X < point2X:
                for j in range(point1X, point2X + 1):
                    occurences[j][point1Y] += 1
            elif point2X < point1X:
                for k in range(point2X, point1X + 1):
                    occurences[k][point1Y] += 1
        # Horizontal lines
        elif point1X == point2X and point1Y != point2Y:
            if point1Y < point2Y:
                for j in range(point1Y, point2Y + 1):
                    occurences[point1X][j] += 1
            elif point2Y < point1Y:
                for k in range(point2Y, point1Y + 1):
                    occurences[point1X][k] += 1
        # Diagonal lines
        # 6, 6
        # 3, 9
        elif point1X != point2X and point1Y != point2Y:
            if point1X < point2X:
                if point1Y < point2Y:
                    for j in range(point2X - point1X + 1):
                        occurences[point1X + j][point1Y + j] += 1
                else:
                    for k in range(point2X - point1X + 1):
                        occurences[point1X + k][point1Y - k] += 1
            elif point1X > point2X:
                if point1Y < point2Y:
                    for j in range(point1X - point2X + 1):  # 0 1 2 3
                        occurences[point1X - j][point1Y + j] += 1
                else:
                    for k in range(point1X - point2X + 1):
                        occurences[point1X - k][point1Y - k] += 1


def generate0Array(x, y):
    result = []
    for i in range(x + 1):
        row = (y + 1) * [0]
        result.append(row)
    return result


def getLargestXandY(inputData):
    largestX = 0
    largestY = 0
    for i in inputData:
        point1 = i.split(" -> ")[0]
        point2 = i.split(" -> ")[1]
        point1X = int(point1.split(",")[0])
        point1Y = int(point1.split(",")[1])
        point2X = int(point2.split(",")[0])
        point2Y = int(point2.split(",")[1])
        if point1X >= point2X and point1X > largestX:
            largestX = point1X
        elif point2X > largestX:
            largestX = point2X
        if point1Y >= point2Y and point1Y > largestY:
            largestY = point1Y
        elif point2Y > largestY:
            largestY = point2Y
    return [largestX, largestY]


if __name__ == "__main__":
    main()
