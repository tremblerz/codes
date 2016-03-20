while [[ true ]];
do
	read s
	if [[ $s == "" ]];
	then
		break
	else
		echo $s|cut -c3,7
	fi
done
