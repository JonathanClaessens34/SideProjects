def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()
    allZero = [0] * len(inputData[0])
    allOne = [0] * len(inputData[0])
    for i in range(len(inputData)):
        binaryInput = inputData[i]
        for j in range(len(binaryInput)):
            if binaryInput[j] == "0":
                allZero[j] += 1
            elif binaryInput[j] == "1":
                allOne[j] += 1

    mostCommon = ""
    leastCommon = ""
    for i in range(len(allZero)):
        if allZero[i] > allOne[i]:
            mostCommon += "0"
            leastCommon += "1"
        elif allZero[i] < allOne[i]:
            mostCommon += "1"
            leastCommon += "0"
        else:
            mostCommon += "0"
            leastCommon += "0"
    print(calcBinToDec(mostCommon) * calcBinToDec(leastCommon))


def calcBinToDec(bin):
    result = 0
    counter = 0
    for i in range(len(bin) - 1, -1, -1):
        result += (int(bin[i]) * (2 ** counter))
        counter += 1
    return result


if __name__ == "__main__":
    main()
