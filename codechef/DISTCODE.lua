t=io.read()
t=tonumber(t)
while(t>0)
do
  t=t-1
  local s,ar,ans=io.read(),{},0
  l=string.len(s)
  k=26
  for i = 1,k
  do
    ar[i]={}
    for j = 1,k
    do
      ar[i][j]=0
    end
  end
  for i = 1,l
  do
--    print (string.byte(s,i),string.byte(s,i+1),"\n")
    if(string.byte(s,i+1) ~= nil)
    then
      ar[string.byte(s,i)-65][string.byte(s,i+1)-65]=1
    end
  end
  for i=1,k
  do
    for j=1,k
    do
      if (ar[i][j] == 1) then
	ans = ans+1
      end
    end
  end
  print(ans)
end
