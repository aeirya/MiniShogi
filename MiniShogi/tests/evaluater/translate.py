line = input()
piece, init, dest = line.split()

def f(grid):
    y, x = list(grid)
    return x+y

print(f"{piece} {f(init)} {f(dest)}")