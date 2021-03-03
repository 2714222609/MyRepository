#import "C:\Program Files\Common Files\System\ado\msado15.dll" no_namespace rename ("EOF", "EndOfFile")
#include <iostream>
#include <iomanip> //for setw()
using namespace std;
class customer
{
public:
	char cid[10]; 
	char cname[10]; 
	char city[10];
	float discount; 
public:
	customer(){}
	~customer(){}
}; 

int main()
{
	customer cus;
	::CoInitialize(NULL); // 初始化OLE/COM库环境 ，为访问ADO接口做准备
	// 创建记录集对象
	_RecordsetPtr m_pRecordset("ADODB.Recordset");
	//m_pRecordset.CreateInstance(__uuidof(Recordset));
	//创建connection对象
	_ConnectionPtr m_pConnection("ADODB.Connection");	   
	//设置连接字符串
	_bstr_t strConnect=("driver={SQL Server};Server=(local)\\sqlexpress;DATABASE=CAP;UID=sa;PWD=sa123456");
	//_bstr_t strConnect= "Provider=SQLOLEDB;Database=CAP; uid=sa; pwd=sa123456;";

	_bstr_t bstrSQL("select * from customers"); //查询语句，表stu_info

	std::cout<<"creating from database..."<<endl;
	try
	{
		m_pConnection->Open(strConnect,"","",adModeUnknown);
		if(m_pConnection==NULL)
			cerr<<"Lind data ERROR!n";
		_variant_t vcid,vcname,vcity,vdiscount; //对应库中的cid,cname,city,discnt
		
		while(1)
		{
			// 取得表中的记录
			m_pRecordset->Open(bstrSQL,m_pConnection.GetInterfacePtr(),adOpenDynamic,adLockOptimistic,adCmdText);
			cout << "cid       cname   city    discnt \n";
			cout<<"n----------------------------------------------------------------n\n";
			while (!m_pRecordset->EndOfFile)
			{
				vcid = m_pRecordset->GetCollect(_variant_t((long)0));
				vcname = m_pRecordset->GetCollect("cname");
				vcity = m_pRecordset->GetCollect("city");
				vdiscount = m_pRecordset->GetCollect("discnt");
				if (vcid.vt != VT_NULL && vcname.vt != VT_NULL && vcity.vt != VT_NULL && vdiscount.vt != VT_NULL )
				{
					cout.setf(ios::left);
					cout << setw(10) << (char*)(_bstr_t)vcid;
					cout << setw(10) << (char*)(_bstr_t)vcname;
					cout << setw(8) << (char*)(_bstr_t)vcity;
					cout <<setw(20) << (char*)(_bstr_t)vdiscount;
					cout.unsetf(ios::left);
					cout << endl;
				}
				m_pRecordset->MoveNext(); ///移到下一条记录
			}
			cout << "n----------------------------------------------------------------n\n";
			m_pRecordset->Update();
			//m_pConnection->Execute(query_cmd,NULL,1); //用Execute执行sql语句来删除
			m_pRecordset->Close(); // 关闭记录集
		}
	}
	// 捕捉异常
	catch(_com_error e)
	{
		// 显示错误信息
	  // cerr << "nERROR:" << (char*)e.Description();//抛出异常
	}
	if(m_pConnection->State)
		m_pConnection->Close();
	::CoUninitialize();
	return 0;
}