read x
read y
read z
if [[ $x -eq $y &&  $x -eq $z  ]]
then
	echo "EQUILATERAL"
elif [[ $x -eq $y || $y -eq $z || $x -eq $z ]]
then
	echo "ISOCELES"
else
	echo "SCALENE"
fi
