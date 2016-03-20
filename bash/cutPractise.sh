a=""
while [[ true ]]
do
	read str
	if [[ "$str" != "$a" ]];
	then
		echo "$str"|cut -c3
	else
		break
	fi
done
