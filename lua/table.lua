print(table.getn{10,2,4})          --> 3
print(table.getn{10,2,nil})        --> 2
print(table.getn{10,2,nil; n=3})   --> 3
print(table.getn{n=1000})          --> 1000

a = {}
print(table.getn(a))               --> 0
table.setn(a, 10000)
print(table.getn(a))               --> 10000

a = {n=10}
print(table.getn(a))               --> 10
table.setn(a, 10000)
print(table.getn(a))  
