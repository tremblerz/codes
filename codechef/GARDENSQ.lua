t=io.read()
t=tonumber(t)
while t>0 do
  t=t-1
--  io.write(t,"\n")
  nm=io.read()
  local n,m,x,count=0,0,0,0
  local row={}
  for i in string.gmatch(nm,"%d") do
    if(x==0) then
      n=tonumber(i)
      x=1
    else
      m=tonumber(i)
    end
  end
--  io.write(n,m,"\n")
  for i=0,n-1 do
    row[i]=io.read()
  end
--  io.write(string.byte(row[0],0))
  for i= 0,n-1 do
    for j= 0,m-1 do
      for length = 1,n do
--	io.write(i,"-",j,"-",length,"\n")
	if(i+length<n and j+length<m) then
--	  io.write(string.byte(row[i],j+1),string.byte(row[i+length],j+1),string.byte(row[i+length],j+length+1),string.byte(row[i],j+length+1),"\n")
	  if(string.byte(row[i],j+1)==string.byte(row[i+length],j+1) and string.byte(row[i],j+1)==string.byte(row[i],j+length+1) and string.byte(row[i],j+1)==string.byte(row[i+length],j+length+1)) then
	    count=count+1
	  end
	end
      end
    end
  end
  io.write(count,"\n")
end
