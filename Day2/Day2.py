def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()
    y = 0
    x = 0
    aim = 0

    for i in range(len(inputData)):
        line = inputData[i]
        param = int(line.split(" ")[1])
        if line.split(" ")[0] == "forward":
            x += param
            y += param * aim
        elif line.split(" ")[0] == "up":
            # y -= param
            aim -= param
        elif line.split(" ")[0] == "down":
            # y += param
            aim += param

    print(x * y)


if __name__ == "__main__":
    main()
