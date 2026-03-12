# Numerics examples

a = 5
print('type of a: ', type(a))

b = 3.14
print('type of b: ', type(b))

c = 2 + 4j
print('type of c: ', type(c))

# String examples
d = 'example'
print('type of d: ', type(d))

e = "example"
print('type of e: ', type(e))

f = '''example'''
print('type of f: ', type(f))

e = '''teste
abc
dfg
'''
print('type of e: ', type(e))
print(e)

f = 'example'
print('type of f: ', type(f))
print(f[0]) #e
print(f[1]) #x
print(f[2]) #a
print(f[3]) #m
print(f[4]) #p
print(f[5]) #l
print(f[6]) #e
print(f[-1]) #e (last character)

# string is immutable
# f[0] = 'E' # this will raise an error

# List examples
# list is mutable
g = [1, 2, 3, 4, 5]
print('type of g: ', type(g))
print(g[0]) #1

h = ['a', 'b', 'c', 'd', 'e']
print('type of h: ', type(h))
print(h[0]) #a

i = [1, 'a', 3.14, [1, 2, 3], (4, 5, 6)]
print('type of i: ', type(i))
print(i)

j = [[1,2,3], [4,5,6], [7,8,9]]
print('type of j: ', type(j))
print(j[0]) # [1, 2, 3]
print(j[1]) # [4, 5, 6]
print(j[2]) # [7, 8, 9]

# add elements to the list
k = [1, 2, 3]
k.append(4)
print(k) # [1, 2, 3, 4]

# add element in especific position
k.insert(0, 0)
print(k) # [0, 1, 2, 3, 4]

# add multiple elements to the list
k.extend([5, 6, 7])
print(k) # [0, 1, 2, 3, 4, 5, 6, 7]

# aceessing nested lists
l = [[1, 2], [3, 4], [5, 6]]
print(l[0]) # [1, 2]
print(l[0][0]) # 1
print(l[0][1]) # 2
print(l[1]) # [3, 4]

# tuples examples
# tuple is immutable
m = (1, 2, 3, 4, 5)
print('type of m: ', type(m))
print(m[0]) #1

# boolean examples
n = True
print('type of n: ', type(n))
o = False
print('type of o: ', type(o))

# set examples
p = set([1, 2, 3, 4, 5])
print('type of p: ', type(p))
p.add(6)
print(p) # {1, 2, 3, 4, 5, 6}

for element in p:
  print(element)

q = set([1, 2, 3, 4, 5])
r = set([4, 5, 6, 7, 8])
print(q.union(r)) # {1, 2, 3, 4, 5, 6, 7, 8}
print(q.intersection(r)) # {4, 5}
print(q.difference(r)) # {1, 2, 3}
print(r.difference(q)) # {8, 6, 7}
print(q.symmetric_difference(r)) # {1, 2, 3, 6, 7, 8}

# dictionary examples
s = {'name': 'John', 'age': 30, 'city': 'New York'}
print('type of s: ', type(s))

name = input('Enter your name: ')
age = int(input('Enter your age: '))
city = input('Enter your city: ')
t = {'name': name, 'age': age, 'city': city}
print(t)
