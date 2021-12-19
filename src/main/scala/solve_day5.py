import re
import collections as coll
from itertools import groupby


def expand(x):
    x1, y1, x2, y2 = x[0], x[1], x[2], x[3]

    if x1 == x2:
        if y1 < y2:
            interval = list(range(y1, y2 + 1))
        elif y2 < y1:
            interval = list(range(y2, y1 + 1))
        return list(zip([x1] * len(interval), interval))
    elif y1 == y2:
        if x1 < x2:
            interval = list(range(x1, x2 + 1))
        elif x2 < x1:
            interval = list(range(x2, x1 + 1))
        return list(zip(interval, [y1] * len(interval)))
    # find diagonal ranger
    # FIXME this gives wrong result
    elif x1 < x2:
        if y1 < y2:
            interval_x = list(range(x1, x2 + 1))
            interval_y = list(range(y1, y2 + 1))
        elif y2 < y1:
            interval_x = list(range(x1, x2 + 1))
            interval_y = list(range(y2, y1 + 1))
        return list(zip(interval_x, interval_y))
    elif x2 < x1:
        if y1 < y2:
            interval_x = list(range(x2, x1 + 1))
            interval_y = list(range(y1, y2 + 1))
        elif y2 < y1:
            interval_x = list(range(x2, x1 + 1))
            interval_y = list(range(y2, y1 + 1))
        return list(zip(interval_x, interval_y))


with open('input/input-5.txt', 'r') as f:
    lines = f.readlines()

rgx = re.compile(',| -> |\n')
data = [rgx.split(i)[:-1] for i in lines]
# filter orthogonal
#data = list(filter(lambda x: x[0] == x[2] or x[1] == x[3], data))
# convert strings to ints
data = list(map(lambda xs: list(map(lambda x: int(x), xs)), data))
# expand coordinates
data = list(map(lambda xs: expand(xs), data))

# concatenate lists in `data` list
data2 = []
for i in data:
    data2 += i


# find occurances of points in data
# for item, count in coll.Counter(data2).items():
    # if count > 1: print(item, count)
    # print(item, count)


# find final solution
res = [item for item, count in coll.Counter(data2).items()
        if count > 1]
print(len(res))

