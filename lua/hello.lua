function fact(n)
	if n == 2 then
		return 2
	else 
		return n*fact(n-1)
	end
end
print("Enter a number");
n = io.read("*number");
print(fact(n));