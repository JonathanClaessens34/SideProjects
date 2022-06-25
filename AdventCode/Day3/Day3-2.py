def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()

    inputDataMost = inputData
    mostCommon = getLastRemaining(inputDataMost, True)
    leastCommon = getLastRemaining(inputDataMost, False)
    print(calcBinToDec(mostCommon) * calcBinToDec(leastCommon))

def getLastRemaining(inputDataMost, getCommon):
    counter = 0
    while len(inputDataMost) > 1:
        validData = []
        if getCommon:
            mostCommon = calcMostCommon(inputDataMost, counter)
        else:
            mostCommon = calcLeastCommon(inputDataMost, counter)
        for i in range(len(inputDataMost)):
            line = inputDataMost[i]
            if line[counter] == mostCommon:
                validData.append(line)
        counter += 1
        inputDataMost = validData
    return inputDataMost[0]


def calcMostCommon(data, counter):
    amount0 = 0
    amount1 = 0
    for i in range(len(data)):
        line = data[i]
        if line[counter] == "1":
            amount1 += 1
        elif line[counter] == "0":
            amount0 += 1
    if amount1 > amount0 or amount1 == amount0:
        return "1"
    else:
        return "0"


def calcLeastCommon(data, counter):
    if calcMostCommon(data, counter) == "1":
        return "0"
    elif calcMostCommon(data, counter) == "0":
        return "1"


def calcBinToDec(bin):
    result = 0
    counter = 0
    for i in range(len(bin) - 1, -1, -1):
        result += (int(bin[i]) * (2 ** counter))
        counter += 1
    return result


if __name__ == "__main__":
    main()
