#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "CLnkQueue.h"
#pragma warning(disable:4996)

int main()
{
    LinkQueue Q;
    CLQ_Create(Q);
    char dowhat[100];
    while (true) {
        scanf("%s", dowhat);
        if (!strcmp(dowhat, "in")) {
            QElemType x;
            scanf("%d", &x);
            CLQ_In(Q, x);
        }
        else if (!strcmp(dowhat, "out")) {
            QElemType item;
            CLQ_Out(Q, item);
        }
        else {
            break;
        }
    }
    int length = CLQ_Length(Q);
    printf("Queue length: %d\n", length);
    printf("Queue data: ");
    CLQ_Print(Q);
    CLQ_Free(Q);
}
