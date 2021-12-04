def main():
    inputFile = open("input.txt").read()
    inputData = inputFile.splitlines()

    guess = inputData[0].split(",")
    boardsData = inputData[2:]
    boardsNums = []
    boardsChosen = []
    indexLastWinBoard = 0
    factor = 0
    getBoardsAndChosen(boardsData, boardsNums, boardsChosen)
    for i in guess:
        for j in range(len(boardsNums)):
            checkBoard(boardsNums[j], boardsChosen[j], int(i))
            if checkBoardWon(boardsChosen[j]):
                indexLastWinBoard = j
                factor = i
    print(getScoreWinningBoard(boardsNums[indexLastWinBoard], boardsChosen[indexLastWinBoard], int(factor)))


def getScoreWinningBoard(boardNums, boardChosen, value):
    result = 0
    for i in range(len(boardChosen)):
        for j in range(len(boardChosen[i])):
            if not boardChosen[i][j]:
                result += int(boardNums[i][j])
    return value * result


def checkBoard(boardNum, boardChosen, value):
    for i in range(len(boardNum)):
        for j in range(len(boardNum[i])):
            if int(boardNum[i][j]) == value:
                boardChosen[i][j] = True


def checkBoardWon(board):
    if checkBoardRows(board) or checkBoardColumns(board):
        return True
    return False


def checkBoardRows(board):
    for i in range(len(board)):
        rowGood = True
        for j in range(len(board[i])):
            if board[i][j] == False:
                rowGood = False
                break
        if rowGood:
            return True
    return False


def checkBoardColumns(board):
    for i in range(len(board[0])):
        columnGood = True
        for j in range(len(board)):
            if board[j][i] == False:
                columnGood = False
                break
        if columnGood:
            return True
    return False


def getBoardsAndChosen(boardsData, boardsNums, boardsChosen):
    for i in range(0, len(boardsData), 6):
        newBoard = []
        newBoard.append(boardsData[i].split())
        newBoard.append(boardsData[i + 1].split())
        newBoard.append(boardsData[i + 2].split())
        newBoard.append(boardsData[i + 3].split())
        newBoard.append(boardsData[i + 4].split())
        boardsNums.append(newBoard)
        boardsChosen.append(getEmptyBoolBoard())


def getEmptyBoolBoard():
    result = []
    for i in range(5):
        result.append(5 * [False])
    return result


if __name__ == "__main__":
    main()
