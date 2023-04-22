#include <stdio.h>  
#include <math.h>  
#include <string.h>
int main()
{
    char s[1000] = { 0 }, ans[1000] = { 0 };
    int pos;
    scanf_s("%s %d", s, &pos);
    int p = 0;
    /***********Begin**************/
    char tem[1000] = { 0 };
    int i;
    for (i = 0; i < pos; i++) tem[i] = s[i];
    for (i = pos; s[i] != 0; i++) ans[i - pos] = s[i];
    for (p; p < pos; p++)ans[p + i] = tem[p];
    ans[p] = 0;







    /***********End**************/
    printf("%s\n", ans);
    return 0;
}