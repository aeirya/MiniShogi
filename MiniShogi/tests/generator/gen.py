from genericpath import isfile
import random

pieces = ['k', 'g', 's', 'b', 'l', 'p']

def rand_piece():
    p = random.choice(pieces)
    if random.randint(0, 1) == 0:
        return p.upper()
    return p

def rand_loc():
    init = random.randint(1, 5)
    dest = random.randint(1, 5)
    return init * 10 + dest


def rand_valid_move():
    board = {
        (1,1): "K",
        (2,1): "G",
        (3,1): "S",
        (4,1): "B",
        (5,1): "L",
        (5,5): "k",
        (4,5): "g",
        (3,5): "s",
        (2,5): "b",
        (1,5): "l"
    }

    def is_free(grid):
        return not grid in board.keys() or board.get(grid) == None
    
    def rand_piece():
        return random.choice(list(board.keys()))

    def rand_grid():
        return 

    def move(init, dest):
        board[dest] = board[init]
        del board[init]

    # grid = rand_grid()
    # print(grid)

    init = rand_grid()
    dest = rand_grid()
    move(init, dest)
    print(board)

    return 

    while True:
        grid = rand_grid()




test_size = random.randint(20, 40)

# for _ in range():
    

rand_valid_move()