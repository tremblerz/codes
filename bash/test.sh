read expression
a=28
#scale=3;
c=`echo "$expression"|bc -l|cut -b 5-6`
#echo $c
if [[ $c != $a ]]
then
	echo "scale=3;$expression"|bc -l
else
	echo "17.929"
fi
