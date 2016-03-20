def fun(col):
	lst=[]
	for i in range(1,10):
		lst.append([])
	lst[1].append(col[0])
	lst[2].append(col[0])
	lst[7].append(col[0])
	lst[8].append(col[0])
	lst[3].append(col[1])
	lst[4].append(col[1])
	lst[5].append(col[1])
	lst[6].append(col[1])
	lst[2].append(col[2])
	lst[4].append(col[2])
	lst[5].append(col[2])
	lst[8].append(col[2])
	lst[1].append(col[3])
	lst[3].append(col[3])
	lst[7].append(col[3])
	lst[6].append(col[3])
	lst[1].append(col[4])
	lst[2].append(col[4])
	lst[3].append(col[4])
	lst[4].append(col[4])
	lst[5].append(col[5])
	lst[6].append(col[5])
	lst[7].append(col[5])
	lst[8].append(col[5])
	return lst
t = int(input())
while t>0:
	t=t-1;
	flag=0
	col=[]
	str1 = raw_input()
	col = str1.split()
	k = fun(col)
#	print k
	for i in range(1,9):
		for color in k[i]:
			if k[i].count(color) == 3:
				flag = 1
				break
		if flag == 1:
			break
	if flag == 0:
		print "NO"
	else:
		print "YES"
