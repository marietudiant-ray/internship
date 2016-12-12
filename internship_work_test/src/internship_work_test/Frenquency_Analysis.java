package internship_work_test;

import java.util.ArrayList;

import internship_work_test.*;
public class Frenquency_Analysis {
	
	public static void zone_frequency_anlalysis(Analysis analysis)
	{
	
		Analysis.freauency_zone=new double[Analysis.zone.length];
		Analysis.frequency_zn=new int[Analysis.zone.length];
		for(int i=0;i<Analysis.freauency_zone.length;i++)
		{
			Analysis.freauency_zone[i]=0;
			Analysis.frequency_zn[i]=0;
		}
		
		
			for(int z=0;z<Analysis.zone.length-1;z++)
			{
			for(int j=0;j<Analysis.province.length;j++)
			{
			//	System.out.println(Analysis.province[j]+"    "+Analysis.zone[z]);
				if(Analysis.zone[z].equals(Analysis.province[j])&&Analysis.province[j]!=null)
				{
					Analysis.frequency_zn[z]+=Analysis.amount[j];
				}
			}
			}
			for(int i=0;i<Analysis.province.length;i++)
			{
				if(Analysis.province[i]==null){
					Analysis.frequency_zn[Analysis.zone.length-1]+=Analysis.amount[i];}
			}
		
		 Basic_data_information.count_total_amount();
		for(int i=0;i<Analysis.zone.length;i++){
		Analysis.freauency_zone[i]=(double) Analysis.frequency_zn[i]/Analysis.total_amount;
		}
	}
	
	public static void yp_id_frequency_analysis(Analysis analysis)
	{
		int count=0;
		int different_id=1;
		Analysis.different_yp_id=new ArrayList<Integer>();
		Analysis.different_yp_id.add(Analysis.yp_id[0]);
		for(int i=1;i<Analysis.yp_id.length;i++)
		{
			for(int j=0;j<Analysis.different_yp_id.size();j++)
			{
				if(Analysis.yp_id[i]==Analysis.different_yp_id.get(j))
				{
				   count++;break;
				}
				
			}
			if(count==0)
			{
				Analysis.different_yp_id.add(Analysis.yp_id[i]);
				different_id++;
			}
			count=0;
		}
		Analysis.frenquency_yp_id=new double[Analysis.different_yp_id.size()];
		Analysis.frequency_yi=new int[Analysis.different_yp_id.size()];
		for(int i=0;i<Analysis.different_yp_id.size();i++)
		{
			Analysis.frenquency_yp_id[i]=0;
			Analysis.frequency_yi[i]=0;
		}
		for(int i=0;i<Analysis.yp_id.length;i++)
		{
			for(int j=0;j<Analysis.different_yp_id.size();j++)
			{
			     if(Analysis.yp_id[i]==Analysis.different_yp_id.get(j))
			     {
			    	 Analysis.frequency_yi[j]+=Analysis.amount[i];
			     }
			}
		}
		Basic_data_information.count_total_amount();
		for(int i=0;i<Analysis.frequency_yi.length;i++)
		{
			Analysis.frenquency_yp_id[i]=(double) Analysis.frequency_yi[i]/Analysis.total_amount;
		}
	}
	
	public static void yp_price_frequency_analysis(Analysis analysis)
	{
		Analysis.frequency_yp_price=new int[119];
		Analysis.frequency_yp=new double[119];
		for(int i=0;i<Analysis.frequency_yp_price.length;i++)
		{
			Analysis.frequency_yp_price[i]=0;
			Analysis.frequency_yp[i]=0;
		}
		for(int i=0;i<Analysis.price.length;i++)
		{
			if(Analysis.price[i]>0&&Analysis.price[i]<=1.0)
			{
				for(int j=0;j<10;j++)
			   {
				  if(Analysis.price[i]>(double)(j/10)&&Analysis.price[i]<=(double)(j+1)/10)
				  {
					  Analysis.frequency_yp_price[j]=Analysis.frequency_yp_price[j]+Analysis.amount[i];
					  break;
				  }
			   }
			}
			else if(Analysis.price[i]>1&&Analysis.price[i]<=100)
			{
				for(int j=1;j<100;j++)
				{
					if(Analysis.price[i]>j&&Analysis.price[i]<=(j+1))
					{
						Analysis.frequency_yp_price[j+9]=Analysis.frequency_yp_price[j+9]+Analysis.amount[i];
						break;
					}
				}
			}
			else if(Analysis.price[i]>100&&Analysis.price[i]<=1000)
			{
				for(int j=1;j<10;j++)
				{
					if(Analysis.price[i]>(j*100)&&Analysis.price[i]<((j+1)*100))
					{
						Analysis.frequency_yp_price[j+108]=Analysis.frequency_yp_price[j+108]+Analysis.amount[i];
					}
				}
			}
			else if(Analysis.price[i]>1000)
			{
				Analysis.frequency_yp_price[118]+=Analysis.amount[i];
			}
		}
		for(int i=0;i<Analysis.frequency_yp_price.length;i++)
		{
			//System.out.println(Analysis.frequency_yp_price[i]+"     "+Analysis.total_amount);
			Analysis.frequency_yp[i]=(double) Analysis.frequency_yp_price[i]/(Analysis.total_amount);
			//System.out.println(Analysis.frequency_yp[i]);
		}
		for(int i=0;i<Analysis.frequency_yp_price.length;i++)
		{
			String sql="insert into 药品价格频率 (quantity,percentage) values "+"("+Analysis.frequency_yp_price[i]+", "+Analysis.frequency_yp[i]+");";
			analysis.connect.execute(sql);
		}
	}

	
}
