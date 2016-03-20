io.write("Learning ",_VERSION,"\n")
x = 15
x = io.read()
x = tonumber(x)
if (x < 10)
then
	io.write("!\n")
elseif (x == 15)
then
	io.write("../..\n")
else
	io.write(".//\n")
end