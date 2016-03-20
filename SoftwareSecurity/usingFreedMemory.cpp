#include<stdio.h>
#include<stdlib.h>
int main()
{
	int *p = (int *)malloc(sizeof(int));
	*p = 5;
	free(p);
	printf("%d\n",*p);
	return 0;
}
