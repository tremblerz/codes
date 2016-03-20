while [[ true ]]
do
	read s
	if [[ $s == "" ]];
	then
		break
	else
		echo $s|cut -b 2-7
	fi
done
