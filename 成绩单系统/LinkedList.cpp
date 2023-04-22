#include"LinkedList.h"
#include<iostream> 
LinkedList::Node* LinkedList::advance(int pos)const
{
    Node* temp = head;
    for (int i = 0; i < pos; i++)
    {
        temp = temp->next;
    }
    return temp;
}
LinkedList::LinkedList()
{
    head = nullptr;
    size = 0;
}
LinkedList::LinkedList(const LinkedList& rhs)
{

    size = rhs.size;
    Node* temp = rhs.head;
    head = new Node;
    head->data = rhs.head->data;
    Node* tail = head;
    for (int i = 1; i < rhs.size; i++)
    {
        Node* pnode = new Node;
        pnode->data = temp->data;
        pnode->next = nullptr;
        temp = temp->next;
        tail->next = pnode;
        tail = pnode;
    }
}
LinkedList::LinkedList(int const a[], int n)
{
    size = n;
    head = new Node;
    head->data = a[0];
    head->next = nullptr;
    Node* tail = head;
    for (int i = 1; i < n; i++)
    {
        Node* pnode = new Node;
        pnode->data = a[i];
        pnode->next = nullptr;
        tail->next = pnode;
        tail = pnode;
    }
}
LinkedList::LinkedList(int n, int value)
{
    size = n;
    head = new Node;
    head->data = value;
    head->next = nullptr;
    Node* tail = head;
    for (int i = 1; i < n; i++)
    {
        Node* pnode = new Node;
        pnode->data = value;
        pnode->next = nullptr;
        tail->next = pnode;
        tail = pnode;
    }
}
LinkedList::~LinkedList()
{
    Node* temp = head;
    for (int i = 0; i < size; i++)
    {
        temp = temp->next;
        delete head;
        head = temp;
    }
}
void LinkedList::insert(int pos, int value)
{
    if (size == 0)
    {
        head = new Node;
        head->data = value;
        head->next = nullptr;
        size++;
    }
    else
    {
        Node* p = head;
        for (int i = 0; i < pos - 1; i++)
        {
            p = p->next;
        }
        Node* pnode = new Node;
        pnode->data = value;
        pnode->next = p->next;
        p->next = pnode;
        size++;
    }
}
void LinkedList::remove(int pos)
{
    if (pos == 0)
    {
        Node* temp = head;
        head = temp->next;
        delete temp;
        temp = nullptr;
        size--;
    }
    else {
        Node* p = head;
        for (int i = 0; i < pos - 1; i++)
        {
            p = p->next;
        }
        Node* temp = p->next;
        p->next = p->next->next;
        delete temp;
        temp = nullptr;
        size--;
    }
}
int LinkedList::at(int pos)const
{
    Node* p = advance(pos);
    return p->data;
}
void LinkedList::modify(int pos, int newvalue)
{
    Node* p = advance(pos);

    p->data = newvalue;
}
void LinkedList::disp()const
{
    for (Node* p = head; p != nullptr; p = p->next)
    {
        std::cout << p->data << " ";
    }
    std::cout << std::endl;
}