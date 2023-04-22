
#include <iostream>

using namespace std;

struct List{
    int val;
    struct List* next;
};

void Init(struct List* L) { //��������
    int cur;
    cin >> cur;
    while (cur != -1) {
        struct List* ptr = (struct List*)malloc(sizeof(struct List));
        ptr->val = cur;
        ptr->next = NULL;
        L->next = ptr;
        L = L->next;
        cin >> cur;
    }
}

void Show(struct List* L) { //��������ֵ
    cout << "�������:";

    while (L->next) {
        cout << L->next->val << " ";
        L = L->next;
    }
    cout << endl;
}

//�ڵ�K��λ��ǰ����dataԪ��,������� �ĵ�K��λ�þ���data
void InsertList(struct List* L, int k, int data) {

    struct List* pre = NULL; //�洢��K-1��Ԫ�ص�ֵ
    struct List* ptr = (struct List*)malloc(sizeof(struct List));   //����ռ�
    ptr->val = data;
    ptr->next = NULL;

    while (k && L->next) {  //���ҵ�����dataԪ�ص�λ��
        pre = L;
        L = L->next;
        k--;
    }

    if (k > 0) {    //���K > 0 ֱ�Ӳ嵽����ı�β
        L->next = ptr;
        L = L->next;
    }
    else {
        pre->next = ptr;    //��������
        ptr->next = L;
    }
}

int lengthList(struct List* L) {   //��������
    int len = 0;
    while (L->next) {
        len++;
        L = L->next;
    }
    return len;
}
void DeleteList(struct List* L, int x) {   //ɾ��ֵΪx�Ľ�㣨�������ظ�ֵ��
    if (lengthList(L) <= 0) {
        cout << "��գ�û��Ԫ�ؿ�ɾ��" << endl;
        return;
    }

    struct List* ptr = L->next;
    struct List* pre = L;   //��¼ptr��ǰһ��λ�õĽ��
    while (ptr) {
        if (ptr->val == x) {
            pre->next = ptr->next;  //��xֵ�Ľ���ǰһ������nextָ��ptr��next���
            free(ptr);  //�ͷſռ�
            return;
        }
        pre = ptr;
        ptr = pre->next;
    }
}

void DeleteList_Position(struct List* L, int k) {   //ɾ����K��λ�õĽ��
    if (lengthList(L) <= 0) {
        cout << "��գ�û��Ԫ�ؿ�ɾ��" << endl;
        return;
    }

    struct List* ptr = L->next;
    struct List* pre = L;   //��¼ptr��ǰһ��λ�õĽ��
    k = k - 1;  //��Ϊ���k = 1,ֱ����pre->next = ptr->next�Ͱ�ptrɾ���ˣ�����Ҫ��1
    while (k-- && ptr) {
        pre = ptr;
        ptr = ptr->next;
    }
    if (ptr == NULL || k > 0) {
        cout << "Ҫɾ����λ�ò�����" << endl;
    }
    else {
        pre->next = ptr->next;  //ɾ��ptr���
        free(ptr);  //�ͷſռ�
    }
}

bool IsEmptyList(struct List* L) {  //�ж������Ƿ�Ϊ��
    if (L->next == NULL) {
        return true;
    }
    else {
        return false;
    }
}


int GetElemList(struct List* L, int i) {    //���ص�i��λ�õ�ֵ
    struct List* ptr = L;
    int k = i;  //���i��ֵ���Է������������ʾ
    while (i > 0 && ptr->next) {
        ptr = ptr->next;
        i--;
    }

    if (i == 0 && ptr != NULL) {    //��i == 0 �� ptr ��Ϊ�մ����ҵ��˵�i��λ�õ�Ԫ��
        return ptr->val;
    }
    else {
        cout << "��" << k << "��λ�ò�����" << endl;
        return -1;
    }
}

void ClearList(struct List* L) {    //�������
    struct List* ptr = L;
    if (lengthList(L) > 0) {
        while (ptr->next) {
            struct List* temp = ptr->next;
            ptr->next = ptr->next->next;
            free(temp);  //�ͷſռ�
        }
    }
}

double Ratio(struct List* head)
{
    int n=0,i=0;
    List* p;
    p = head;
    int len = lengthList(head);
    if (head->next == NULL) {
        return -1;
    }
        for (i; i < len; i++)
        {
            if (p->next->val > 0)
            {
                n++;
            }
            p = p->next;
        }
        double k = n / len;
        return n;
}

int main() {

    struct List* head = (struct List*)malloc(sizeof(struct List)); //ͷ���(����ֵ)
    head->next = NULL;


    while (1)
    {
        cout << "**********************************************" << endl;
        cout << "* 1������������(��-1����)     2����ӡ������  *" << endl;
        cout << "* 3�����뵥����               4��������ɾ��  *" << endl;
        cout << "* 5���ж��Ƿ�Ϊ��             6����������  *" << endl;
        cout << "* 7������                     8���˳�        *" << endl;
        cout << "**********************************************" << endl;

        int  k;
        cout << "���������ѡ��";
        cin >> k;
        switch (k)
        {

        case 1:
            Init(head);      //����������
            system("pause");
            system("cls");
            continue;

        case 2:
            Show(head);            //����������
            system("pause");
            system("cls");
            continue;

        case 3:

            int i, data;
            cout << "������Ҫ�����λ�ú�ֵ��";
            cin >> i;
            cin >> data;
            InsertList(head, i, data);
            Show(head);
            system("pause");
            system("cls");
            continue;


        case 4:

            int x;
            cout << "������Ҫɾ����ֵ: ";
            cin >> x;

            DeleteList(head, x);    //ɾ��������ֵΪx�Ľ�㣨����ֵ���ظ���

            system("pause");
            system("cls");
            continue;

        case 5:
            if (IsEmptyList(head))
                cout << "�����ǿ�����!" << endl;
            else
                cout << "������!" << endl;

            system("pause");
            system("cls");
            continue;
        case 6:

            cout << "����ĳ���Ϊ: " << lengthList(head) << endl;

            system("pause");
            system("cls");
            continue;

        case 7:
            int n;
            cout << "������Ҫ���ҵ�λ��: ";
            cin >> n;
            if (GetElemList(head, n) != -1)
                cout << "��" << n << "��λ�õ�ֵΪ: " << GetElemList(head, n) << endl;
            system("pause");
            system("cls");
            continue;

        case 9:
            double c;
            c = Ratio(head);
            cout << Ratio(head)/lengthList(head) << endl;
            system("pause");
            system("cls");
            continue;

        case 8:
            break;

        default:
            cout << "��������ȷ��ѡ��!!!" << endl;
            system("pause");
            system("cls");
            continue;


        }
        system("cls");
        break;


    }
    system("pause");
    return 0;

}


