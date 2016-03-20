read n
s=0
for (( i=0;i<n;i++ ))
do
	read x
	s=`expr $x + $s`
done
a=$(echo "scale=3;$s/$n"|bc -l)
if (( $(echo $a) == $(echo "0") ))
then
	echo "0.000"
else
	echo $a
fi
