while [[ true ]]
do
	read s
	if [[ $s == "" ]];
	then
		break
	else
		echo $s|cut -c-4
	fi
done
