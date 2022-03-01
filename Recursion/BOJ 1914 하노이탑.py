def hanoi(start, goal, assi, n):
    if n == 1:
        print(start, goal, sep= " ")
    else:
        hanoi(start, assi, goal, n - 1)
        hanoi(start, goal, assi, 1)
        hanoi(assi, goal, start, n - 1)


n = int(input())
print(2**n-1)
if n <= 20:
    hanoi(1, 3, 2, n)
