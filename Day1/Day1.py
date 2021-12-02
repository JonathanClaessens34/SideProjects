def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()
    result = 0

    for i in range(len(inputData)-3):
        if int(inputData[i]) + int(inputData[i+1]) + int(inputData[i+2]) < int(inputData[i+1]) + int(inputData[i+2]) + int(inputData[i+3]):
            result += 1
    print(result)


if __name__ == "__main__":
    main()
