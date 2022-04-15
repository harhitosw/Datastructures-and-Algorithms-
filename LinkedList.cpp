
#include<bits/stdc++.h>
using namespace std;
typedef struct employ{
    string name;
    string dpt;
    int IDno;
    int mobno;
    struct employ *nxt;
}*Entry;

Entry getdata(){
    Entry obj;
    obj=new(struct employ);
    cout<<"Enter the Name of employe"<<endl;
    cin>>obj->name;
    cout<<"Enter the department of employe"<<endl;
    cin>>obj->dpt;
    cout<<"Enter the ID Number of employee"<<endl;
    cin>>obj->IDno;
    cout<<"Enter the Mobile Number of employee"<<endl;
    cin>>obj->mobno;
    obj->nxt=NULL;
    return(obj);
}

Entry createnode(Entry firstnode){
    Entry obj,new_node;
    char ch;
    do{
        new_node=getdata();
        if(firstnode==NULL){
            firstnode=new_node;
        }
        else{
            obj=firstnode;
            while(obj->nxt!=NULL){
                obj=obj->nxt;
            }
            obj->nxt=new_node;
        }
        cout<<"Do you wwanna add more nodes(y/n)"<<endl;
        cin>>ch;
        
    }while(ch=='Y'||ch=='y');
    return firstnode;
}
Entry insertbegin(Entry firstnode){
    Entry tempnode;
    tempnode=getdata();
    tempnode->nxt=firstnode;
    firstnode=tempnode;
    return firstnode;
}
Entry insertatpos(Entry firstnode){
    Entry tempnode,tempnode1;
    int pos,j;
    cout<<"Enter the position where node is to be inserted "<<endl;
    cin>>pos;
    j=1;
    tempnode=getdata();
    tempnode1=firstnode;
    
    while(j<pos-1){
        if(tempnode1->nxt==NULL){
            cout<<"Invalid position"<<endl;
            return firstnode;
        }
        
        tempnode1=tempnode1->nxt;
    }
     tempnode->nxt=tempnode1->nxt;
    tempnode1->nxt=tempnode;
    return firstnode;
}
Entry insertatend(Entry firstnode){
    Entry tem,temp1;
    temp1=getdata();
    tem=firstnode;
    while(tem->nxt!=NULL){
        tem=tem->nxt;
    }
    tem->nxt=temp1;
    return firstnode;
}

Entry deletebegin(Entry firstnode){
    Entry temp;
    if(firstnode==NULL){
        cout<<"Empty list "<<endl;
    }
    else{
        temp=firstnode;
       firstnode=firstnode->nxt;
       cout<<"Deleted data"<<endl;
        cout<<"Name of employee : "<<temp->name<<endl;
        cout<<"Department of employee : "<<temp->dpt<<endl;
     cout<<"ID Number of employee : "<<temp->IDno<<endl;
    cout<<"Mobile number of employee : "<<temp->mobno<<endl;
    delete temp;
    }
    return firstnode;
}
Entry deleteatpos(Entry firstnode){
    Entry temp,temp1;
    int pos;
    if(firstnode==NULL){
        cout<<"\n EMPTY LIST ";
    }
  else{
      cout<<"\n Enter the ID to be deleted ";
      cin>>pos;
      temp=firstnode;
      while(temp->IDno!=pos){
          temp1=temp;
          temp=temp->nxt;
      }
      temp1->nxt=temp->nxt;
      cout<<"\n DELETED RECORD";
       cout<<"Name of employee : "<<temp->name<<endl;
             cout<<"Department of employee : "<<temp->dpt<<endl;
             cout<<"ID Number of employee : "<<temp->IDno<<endl;
             cout<<"Mobile number of employee : "<<temp->mobno<<endl;
             delete temp;
  }
  return firstnode;
}
Entry DeleteatEnd(Entry firstnode){
    Entry temp,temp1;
    if(firstnode==NULL){
        cout<<"\n EMPTY LIST";
    }
    else{
        temp=firstnode;
        while(temp->nxt!=NULL){
            temp1=temp;
            temp=temp->nxt;
        }
        temp1->nxt=NULL;
        cout<<"\n DELETED RECORD IS ";
        cout<<"Name of employee : "<<temp->name<<endl;
             cout<<"Department of employee : "<<temp->dpt<<endl;
             cout<<"ID Number of employee : "<<temp->IDno<<endl;
             cout<<"Mobile number of employee : "<<temp->mobno<<endl;
             delete temp;
    }
    return firstnode;
}
void search_node(Entry firstnode){
    Entry temp;
    int empid;
    cout<<"\n Enter the ID of employ to be searched ";
    cin>>empid;
    temp=firstnode;
    while(temp!=NULL && temp->IDno!=empid)
        temp=temp->nxt;
    if(temp==NULL)
    cout<<"\n Record Not Found";
    else
     cout<<"Name of employee : "<<temp->name<<endl;
             cout<<"Department of employee : "<<temp->dpt<<endl;
             cout<<"ID Number of employee : "<<temp->IDno<<endl;
             cout<<"Mobile number of employee : "<<temp->mobno<<endl;
}
 
 void modify_Data(Entry firstnode){
     int empid;
     Entry temp;
     cout<<"\n Enter the ID of employee to be modified";
     cin>>empid;
     temp=firstnode;
     while(temp!=NULL){
         if(temp->IDno==empid){
             cout<<"Enter the Name of employe"<<endl;
    cin>>temp->name;
    cout<<"Enter the department of employe"<<endl;
    cin>>temp->dpt;
    cout<<"Enter the ID Number of employee"<<endl;
    cin>>temp->IDno;
    cout<<"Enter the Mobile Number of employee"<<endl;
    cin>>temp->mobno;
    break;
         }
         temp=temp->nxt;
         
     }
 }
 void display_data(Entry firstnode)
 {
     Entry obj,tempobj;
     if(firstnode==NULL)
     {
         cout<<"\n The list is Empty";
     }
     else
     {
         tempobj=firstnode;
         while(tempobj!=NULL)
         {
             cout<<"Name of employee : "<<tempobj->name<<endl;
             cout<<"Department of employee : "<<tempobj->dpt<<endl;
             cout<<"ID Number of employee : "<<tempobj->IDno<<endl;
             cout<<"Mobile number of employee : "<<tempobj->mobno<<endl;
             tempobj=tempobj->nxt;
             cout<<endl;
         }
     }
         
     
 }
 int main(){
      int choice;
    char exitcode;
    Entry temp,firstnode=NULL;
    do
    {
        cout<<"Singly linked list";
        cout<<"\n1.Create Linked list \t 2.Display Linked List \t 3.Search\n";
        cout<<"4.Insert node at begin \t 5.Insert node at end \t 6.Insert node at position\n";
        cout<<"7.Delete node at begin \t 8.Delete node at end \t 9.Delete node at position\n";
        cout<<"10.Modify a node \t 11.Exit \n";
        cout<<"Enter your choice: ";
        cin>>choice;
        switch(choice)
        {
            case 1:
                    firstnode=createnode(firstnode);
                    break;
            case 2:
                    display_data(firstnode);
                    break;
            case 3:
                    search_node(firstnode);
                    break;
            case 4:
                   firstnode=insertbegin(firstnode);
                    break;
            case 5:
                    insertatend(firstnode);
                    break;
            case 6:
                    insertatpos(firstnode);
                    break;
            case 7:
                   firstnode=deletebegin(firstnode);
                    break;
            case 8:
                    DeleteatEnd(firstnode);
                    break;
            case 9:
                    deleteatpos(firstnode);
                    break;
            case 10:
                    modify_Data(firstnode);
                    break;
            case 11:
                   exit;
                   break;
            
            default:
                    cout<<"Wrong Choice enter from (1-11)";
                    break;
        }
        cout<<"\nDo you want to continue with the SLL OPERATIONS?[Y/N]"<<endl;
        cin>>exitcode;
    }while(exitcode=='Y' || exitcode=='y');

     return 0;
 }



