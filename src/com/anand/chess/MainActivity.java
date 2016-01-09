package com.anand.chess;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener{
	ImageView ivturn,ivboard,ivscreen,iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14,iv15,iv16,iv17,iv18,iv19,iv20,iv21,iv22,iv23,iv24,iv25,iv26,iv27,iv28,iv29,iv30,iv31,iv32,iv33,iv34,iv35,iv36,iv37,iv38,iv39,iv40,iv41,iv42,iv43,iv44,iv45,iv46,iv47,iv48,iv49,iv50,iv51,iv52,iv53,iv54,iv55,iv56,iv57,iv58,iv59,iv60,iv61,iv62,iv63,iv64;
	TextView tv1;
	private TextToSpeech mTts;
	// white initialpawn=100 pawn=1 rook=2 knight=3 bishop=4 queen=5 king=6
	//black initialpawn=700 pawn=7 rook=8 knight=9 bishop=10 queen=11 king=12
	//empty=0;
	int[] a={2,3,4,5,6,4,3,2,100,100,100,100,100,100,100,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,700,700,700,700,700,700,700,700,8,9,10,11,12,10,9,8};
	int[] b={11,12,13,14,15,16,17,18,21,22,23,24,25,26,27,28,31,32,33,34,35,36,37,38,41,42,43,44,45,46,47,48,51,52,53,54,55,56,57,58,61,62,63,64,65,66,67,68,71,72,73,74,75,76,77,78,81,82,83,84,85,86,87,88};
	int backpressed=0,generatecheckmate=0,mode=1,generatefrom=0,generateto=0,fiftymovecountblack=0,fiftymovecountwhite=0,blackpiececount=16,whitepiececount=16,turn=0,prevoldpos,prevnewpos,wcastleking,wcastlerook1=0,wcastlerook2=0,bcastleking=0,bcastlerook1=0,bcastlerook2=0;
	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Bundle gotbasket =getIntent().getExtras();
		mode=gotbasket.getInt("mode");
		if(mode==1)
		{
			Toast.makeText(this, "Single Player", Toast.LENGTH_SHORT).show();
		}
		else if(mode==2)
		{
			Toast.makeText(this, "Two Player", Toast.LENGTH_SHORT).show();
		}
		mTts = new TextToSpeech(this, this);
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
		mAccel = 0.00f;
		mAccelCurrent = SensorManager.GRAVITY_EARTH;
		mAccelLast = SensorManager.GRAVITY_EARTH;
		wcastleking=2;wcastlerook1=2;wcastlerook2=2;bcastleking=2;bcastlerook1=2;bcastlerook2=2;
		ivboard=(ImageView) findViewById(R.id.imageViewboard);
		ivscreen=(ImageView) findViewById(R.id.imageViewScreen);
		tv1=(TextView) findViewById(R.id.textView1);
		iv1=(ImageView) findViewById(R.id.imageView1);
		iv2=(ImageView) findViewById(R.id.imageView2);
		iv3=(ImageView) findViewById(R.id.imageView3);
		iv4=(ImageView) findViewById(R.id.imageView4);
		iv5=(ImageView) findViewById(R.id.imageView5);
		iv6=(ImageView) findViewById(R.id.imageView6);
		iv7=(ImageView) findViewById(R.id.imageView7);
		iv8=(ImageView) findViewById(R.id.imageView8);
		iv9=(ImageView) findViewById(R.id.imageView9);
		iv10=(ImageView) findViewById(R.id.imageView10);
		iv11=(ImageView) findViewById(R.id.imageView11);
		iv12=(ImageView) findViewById(R.id.imageView12);
		iv13=(ImageView) findViewById(R.id.imageView13);
		iv14=(ImageView) findViewById(R.id.imageView14);
		iv15=(ImageView) findViewById(R.id.imageView15);
		iv16=(ImageView) findViewById(R.id.imageView16);
		iv17=(ImageView) findViewById(R.id.imageView17);
		iv18=(ImageView) findViewById(R.id.imageView18);
		iv19=(ImageView) findViewById(R.id.imageView19);
		iv20=(ImageView) findViewById(R.id.imageView20);
		iv21=(ImageView) findViewById(R.id.imageView21);
		iv22=(ImageView) findViewById(R.id.imageView22);
		iv23=(ImageView) findViewById(R.id.imageView23);
		iv24=(ImageView) findViewById(R.id.imageView24);
		iv25=(ImageView) findViewById(R.id.imageView25);
		iv26=(ImageView) findViewById(R.id.imageView26);
		iv27=(ImageView) findViewById(R.id.imageView27);
		iv28=(ImageView) findViewById(R.id.imageView28);
		iv29=(ImageView) findViewById(R.id.imageView29);
		iv30=(ImageView) findViewById(R.id.imageView30);
		iv31=(ImageView) findViewById(R.id.imageView31);
		iv32=(ImageView) findViewById(R.id.imageView32);
		iv33=(ImageView) findViewById(R.id.imageView33);
		iv34=(ImageView) findViewById(R.id.imageView34);
		iv35=(ImageView) findViewById(R.id.imageView35);
		iv36=(ImageView) findViewById(R.id.imageView36);
		iv37=(ImageView) findViewById(R.id.imageView37);
		iv38=(ImageView) findViewById(R.id.imageView38);
		iv39=(ImageView) findViewById(R.id.imageView39);
		iv40=(ImageView) findViewById(R.id.imageView40);
		iv41=(ImageView) findViewById(R.id.imageView41);
		iv42=(ImageView) findViewById(R.id.imageView42);
		iv43=(ImageView) findViewById(R.id.imageView43);
		iv44=(ImageView) findViewById(R.id.imageView44);
		iv45=(ImageView) findViewById(R.id.imageView45);
		iv46=(ImageView) findViewById(R.id.imageView46);
		iv47=(ImageView) findViewById(R.id.imageView47);
		iv48=(ImageView) findViewById(R.id.imageView48);
		iv49=(ImageView) findViewById(R.id.imageView49);
		iv50=(ImageView) findViewById(R.id.imageView50);
		iv51=(ImageView) findViewById(R.id.imageView51);
		iv52=(ImageView) findViewById(R.id.imageView52);
		iv53=(ImageView) findViewById(R.id.imageView53);
		iv54=(ImageView) findViewById(R.id.imageView54);
		iv55=(ImageView) findViewById(R.id.imageView55);
		iv56=(ImageView) findViewById(R.id.imageView56);
		iv57=(ImageView) findViewById(R.id.imageView57);
		iv58=(ImageView) findViewById(R.id.imageView58);
		iv59=(ImageView) findViewById(R.id.imageView59);
		iv60=(ImageView) findViewById(R.id.imageView60);
		iv61=(ImageView) findViewById(R.id.imageView61);
		iv62=(ImageView) findViewById(R.id.imageView62);
		iv63=(ImageView) findViewById(R.id.imageView63);
		iv64=(ImageView) findViewById(R.id.imageView64);
		ivturn=(ImageView) findViewById(R.id.imageView65);
		Typeface tf = Typeface.createFromAsset(getAssets(), "OldLondonAlternate.ttf");
		tv1.setTypeface(tf);
		disp();

		ivscreen.setOnLongClickListener(new OnLongClickListener() 
		{
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				startVoiceRecognitionActivity();
				return false;
			}
		});

	}

	public void move(int oldpos,int newpos)
	{
		int x1,x2,movesucess=0,i,blackbishopcount=0,blackknightcount=0,whitebishopcount=0,whiteknightcount=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		int chkr=check(oldpos,newpos);
		for(i=0,whitepiececount=0,blackpiececount=0,blackbishopcount=0,blackknightcount=0,whitebishopcount=0,whiteknightcount=0;i<64;i++)
		{
			if(a[i]==100|| a[i]==1 || a[i]==2 || a[i]==3 ||a[i]==4|| a[i]==5 || a[i]==6)
			{
				whitepiececount++;
				if(a[i]==3)
					whiteknightcount++;
				if(a[i]==4)
					whitebishopcount++;
			}
			else if(a[i]==700||a[i]==7 || a[i]==8 || a[i]==9 ||a[i]==10|| a[i]==11 || a[i]==12)
			{
				blackpiececount++;
				if(a[i]==9)
					blackknightcount++;
				if(a[i]==10)
					blackbishopcount++;
			}	
		}
		if(blackpiececount==1 && whitepiececount==1)
		{
			tv1.setText("Draw Match");
			say("   Draw Match.");
		}
		else if((blackpiececount==1 && whitepiececount==2 && (whiteknightcount==1 || whitebishopcount==1))||(blackpiececount==2 && whitepiececount==1 && (blackknightcount==1 || blackbishopcount==1)))
		{
			tv1.setText("Draw Match");
			say("   Draw Match.");
		}
		if(fiftymovecountblack>=50 ||fiftymovecountwhite>=50)
		{
			tv1.setText("Draw Match");
			say(" 50 move.  Draw Match.");
		}

		if(chkr==0)
		{
			int value=a[oldpos];
			if(turn%2==0)
			{
				prevoldpos=a[oldpos];
				prevnewpos=a[newpos];
				if(a[oldpos]==100 )
				{
					a[oldpos]=0;
					a[newpos]=1;
					tv1.setText(b[oldpos]+" --> "+b[newpos]);
					if(whitepiececount==1)
					{
						fiftymovecountwhite++;
					}
					turn++;
					ivturn.setImageResource(R.drawable.turnblack);
					if(stalemate()==0)
					{
						tv1.setText("Stale Mate");
						say("   Stale Mate.");
					}
					if(mode==1)
					{
						generate();
						move(generatefrom,generateto);
					}
				}
				else
				{
					a[oldpos]=0;
					a[newpos]=value;
					tv1.setText(b[oldpos]+" --> "+b[newpos]);
					if(whitepiececount==1 && turn%2==0)
					{
						fiftymovecountwhite++;
					}
					turn++;
					ivturn.setImageResource(R.drawable.turnblack);
					if(stalemate()==0)
					{
						tv1.setText("Stale Mate");
						say("   Stale Mate.");
					}
					if(x1==1 && x2==1)
					{
						wcastlerook1++;
					}
					else if(x1==1 && x2==8)
					{
						wcastlerook2++;
					}
					else if(x1==1 && x2==5)
					{
						wcastleking++;
					}
					movesucess=0;
					if(mode==1)
					{
						generate();
						move(generatefrom,generateto);
					}
				}	
				if(whitecheck()!=0)
				{
					tv1.setText("illegal move");
					a[oldpos]=prevoldpos;
					a[newpos]=prevnewpos;
					if(whitepiececount==1)
					{
						fiftymovecountwhite--;
					}
					turn--;
					ivturn.setImageResource(R.drawable.turnwhite);
					if(x1==1 && x2==1 && wcastlerook1==1)
					{
						wcastlerook1--;
					}
					else if(x1==1 && x2==8 && wcastlerook2==1)
					{
						wcastlerook2--;
					}
					else if(x1==1 && x2==5 && wcastleking==1)
					{
						wcastleking--;
					}
					movesucess=1;
					say("   Illegal Move.");

				}

				if(blackcheck()!=0)
				{
					tv1.setText("black in check");
					checkmate(2);
					say("   Check to  Black.");
				} 

				if(movesucess==0)
				{
					whitepromotion(newpos);
				}

			}

			else if(turn%2!=0)
			{
				prevoldpos=a[oldpos];
				prevnewpos=a[newpos];
				if(a[oldpos]==700 )
				{
					a[oldpos]=0;
					a[newpos]=7;
					tv1.setText(b[oldpos]+" --> "+b[newpos]);
					if(blackpiececount==1)
					{
						fiftymovecountblack++;
					}
					turn++;
					ivturn.setImageResource(R.drawable.turnwhite);
					if(stalemate()==0)
					{
						tv1.setText("Stale Mate");
						say("   Stale Mate.");
					}
				}
				else
				{
					a[oldpos]=0;
					a[newpos]=value;
					tv1.setText(b[oldpos]+" --> "+b[newpos]);
					if(blackpiececount==1)
					{
						fiftymovecountblack++;
					}
					turn++;
					ivturn.setImageResource(R.drawable.turnwhite);
					if(stalemate()==0)
					{
						tv1.setText("Stale Mate");
						say("   Stale Mate.");
					}
					if(x1==8 && x2==1)
					{
						bcastlerook1++;
					}
					else if(x1==8 && x2==8)
					{
						bcastlerook2++;
					}
					else if(x1==8 && x2==5)
					{
						bcastleking++;
					}
					movesucess=0;

				}	
				if(blackcheck()!=0)
				{
					tv1.setText("illegal move");
					a[oldpos]=prevoldpos;
					a[newpos]=prevnewpos;
					if(blackpiececount==1)
					{
						fiftymovecountblack--;
					}
					turn--;
					ivturn.setImageResource(R.drawable.turnblack);
					if(x1==8 && x2==1 && bcastlerook1==1)
					{
						bcastlerook1--;
					}
					else if(x1==8 && x2==8 && bcastlerook2==1)
					{
						bcastlerook2--;
					}
					else if(x1==8 && x2==5 && bcastleking==1)
					{
						bcastleking--;
					}
					movesucess=1;
					say("   Illegal Move.");
				}
				if(whitecheck()!=0)
				{
					tv1.setText("white in check");
					checkmate(1);
					say("   Check to  White.");
				} 

				if(movesucess==0)
				{
					blackpromotion(newpos);
				}
			}

			disp();

		}
		else if(chkr==-100 && turn%2==0)
		{
			tv1.setText("Castled");
			disp();
			if(blackcheck()!=0)
			{
				tv1.setText("black in check");
				say("   Check to  Black.");
				checkmate(2);
			}
		}
		else if(chkr==-700 && turn%2!=0)
		{
			tv1.setText("Castled");
			disp();
			if(whitecheck()!=0)
			{
				tv1.setText("white in check");
				say("   Check to  White.");
				checkmate(1);
			}

		} 
		else
		{
			tv1.setText("Invalid move");
			say("   Invalid move.");
		}

	}

	public int stalemate()
	{
		int count=0,ret1=0,newpos,oldpos;
		for(int i=0;i<64;i++)
		{
			if((turn%2==0 && (a[i]==100||a[i]==1 || a[i]==2 || a[i]==3 ||a[i]==4|| a[i]==5 || a[i]==6))||(turn%2!=0 && (a[i]==700 || a[i]==7 || a[i]==8 ||a[i]==9|| a[i]==10 || a[i]==11 || a[i]==12)))
				for(int j=0;j<64;j++)
				{
					if(check(i,j)==0)
					{
						newpos=a[j];
						oldpos=a[i];
						a[i]=0;
						a[j]=oldpos;
						if((blackcheck()==0 && turn%2!=0)||(whitecheck()==0 && turn%2==0))
						{
							count++;
						}
						a[j]=newpos;
						a[i]=oldpos;
					}

				}
			if(count!=0)
				ret1=1;
		}
		return(ret1);
	}

	//checks if the move is valid
	public int check(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(!(y1>8 || y2>8 ||y1<0 || y2<0))
		{
			switch(a[oldpos])
			{
			case 100:
				if(turn%2==0)
					ret=whiteenpassant(oldpos, newpos);
				break;
			case 1:
				if(turn%2==0)
					ret=whitepawn(oldpos, newpos);
				break;
			case 2:
				if(turn%2==0)
					if((x1!=y1 && x2==y2)||(x1==y1 && x2!=y2))
					{
						ret=whiterook(oldpos,newpos);
					}
				break;
			case 3:
				if(turn%2==0)
					ret=whiteknight(oldpos, newpos);
				break;
			case 4:
				if(turn%2==0)
					if((x1-y1 == x2-y2)||(x1-y1==y2-x2))
					{
						ret=whitebishop(oldpos,newpos);
					}
				break;
			case 5:
				if(turn%2==0)
				{
					if((x1!=y1 && x2==y2)||(x1==y1 && x2!=y2))
					{
						ret=whitequeenstraight(oldpos, newpos);
					}
					else if((x1-y1 == x2-y2)||(x1-y1==y2-x2))
					{
						ret=whitequeendiagonal(oldpos, newpos);
					}
				}
				break;
			case 6:
				if(turn%2==0)
					ret=whiteking(oldpos, newpos);
				break;
			case 700:
				if(turn%2!=0)
					ret=blackenpassant(oldpos, newpos);
				break;
			case 7:
				if(turn%2!=0)
					ret=blackpawn(oldpos, newpos);
				break;
			case 8:
				if(turn%2!=0)
					if((x1!=y1 && x2==y2)||(x1==y1 && x2!=y2))
					{
						ret=blackrook(oldpos,newpos);
					}
				break;
			case 9:
				if(turn%2!=0)
					ret=blackknight(oldpos, newpos);
				break;
			case 10:
				if(turn%2!=0)
					if((x1-y1 == x2-y2)||(x1-y1==y2-x2))
					{
						ret=blackbishop(oldpos,newpos);
					}
				break;
			case 11:
				if(turn%2!=0)
				{
					if((x1!=y1 && x2==y2)||(x1==y1 && x2!=y2))
					{
						ret=blackqueenstraight(oldpos, newpos);
					}
					else if((x1-y1 == x2-y2)||(x1-y1==y2-x2))
					{
						ret=blackqueendiagonal(oldpos, newpos);
					}
				}
				break;
			case 12:
				if(turn%2!=0)
					ret=blackking(oldpos, newpos);
				break;
			}
		}
		return(ret);
	}






	public int whitecheck()
	{
		int i,j,x1,x2,y1,y2,count=0,z;
		//find
		for(i=0;i<64;i++)
		{
			if(a[i]==6)
				break;
		}
		x1=b[i]/10;
		x2=b[i]%10;

		//rook & queen straight
		if(i+8<64)
		{
			for(j=i+8;j<64 && b[j]%10==x2;j+=8)
			{
				if(a[j]==8 || a[j]==11)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i-8>=0)
		{
			for(j=i-8;j>=0 && b[j]%10==x2;j-=8)
			{
				if(a[j]==8 || a[j]==11)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i-1>=0)
		{
			for(j=i-1;j>=0 && b[j]/10==x1;j--)
			{
				if(a[j]==8 || a[j]==11)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i+1<64)
		{
			for(j=i+1;j<64 && b[j]/10==x1;j++)
			{
				if(a[j]==8 || a[j]==11)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		//bishop & queen diagonal
		for(j=i+9,z=0;j<64 &&z==0;j+=9)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if((x2==1))
				break;
			if(a[j]==10 || a[j]==11)
				count++;
			if(y2 == 8 || y1 ==8 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i-9,z=0;j>=0 && z==0;j-=9)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if((x2==8))
				break;
			if(a[j]==10 || a[j]==11)
				count++;
			if(y2 == 0 || y1 ==0 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i+7,z=0;j<64 && z==0;j+=7)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if((x2==8))
				break;
			if(a[j]==10 || a[j]==11)
				count++;
			if(y2 == 8 || y1 ==0 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i-7,z=0;j>=0 && z==0;j-=7)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if((x2==1))
				break;
			if(a[j]==10 || a[j]==11)
				count++;
			if(y2 == 0 || y1 ==8 )
				z++;
			if(a[j]!=0)
				break;
		}

		//pawn
		if(i+7<64)
		{
			y2=b[i+7]%10;
			if((a[i+7]==700||a[i+7]==7) && y2!=8)
			{
				count++;
			}
		}
		if(i+9<64)
		{
			y2=b[i+9]%10;
			if((a[i+9]==700||a[i+9]==7)&&y2!=1)
			{
				count++;
			}
		}

		//king
		if(i+7<64)
		{
			y2=b[i+7]%10;
			if(a[i+7]==12&& y2!=8)
				count++;
		}

		if(i-7>=0)
		{
			y2=b[i-7]%10;
			if(a[i-7]==12&& y2!=1)
				count++;
		}
		if(i+9<64)
		{
			y2=b[i+9]%10;
			if(a[i+9]==12 && y2!=1)
				count++;
		}
		if(i-9>=0)
		{
			y2=b[i-9]%10;
			if(a[i-9]==12 && y2!=8)
				count++;
		}
		if(i+8<64)
		{
			if(a[i+8]==12)
				count++;
		}
		if(i-8>=0)
		{
			if(a[i-8]==12)
				count++;
		}
		if(i-1>=0)
		{
			y2=b[i-1]%10;
			if(a[i-1]==12 && y2!=8)
				count++;
		}
		if(i+1<64)
		{
			y2=b[i+1]%10;
			if(a[i+1]==12&& y2!=1)
				count++;
		}

		//knight
		x2=b[i]%10;
		if(i+6<64)
		{
			if(a[i+6]==9 && x2>=2)
				count++;
		}
		if(i+10<64)
		{
			if(a[i+10]==9  && x2<=6)
				count++;
		}
		if(i+15<64)
		{
			if(a[i+15]==9 && x2>=1)
				count++;
		}
		if(i+17<64)
		{
			if(a[i+17]==9 && x2<=7)
				count++;
		}
		if(i-6>=0)
		{
			if(a[i-6]==9 && x2<=6)
				count++;
		}
		if(i-10>=0)
		{
			if(a[i-10]==9 && x2>=2)
				count++;
		}
		if(i-15>=0)
		{
			if(a[i-15]==9 && x2<=7)
				count++;
		}
		if(i-17>=0)
		{
			if(a[i-17]==9 && x2>=1)
				count++;
		}

		return(count);
	}




	public void whitepromotion(int newpos)
	{
		int y1;
		y1=b[newpos]/10;
		if(y1==8 && a[newpos]==1)
		{
			a[newpos]=5;
			disp();
			tv1.setText("Promotion");
		}
	}


	public int whitequeendiagonal(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=0,i,j=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(y1>x1 && y2>x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*9]==100 || a[oldpos+i*9]==1 || a[oldpos+i*9]==2 || a[oldpos+i*9]==3 || a[oldpos+i*9]==4 || a[oldpos+i*9]==5 || a[oldpos+i*9]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i*9]!=0)
					j++;

			}
		}

		else if(y1<x1 && y2<x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*9]==100 || a[oldpos-i*9]==1 || a[oldpos-i*9]==2 || a[oldpos-i*9]==3 || a[oldpos-i*9]==4 || a[oldpos-i*9]==5 || a[oldpos-i*9]==6)

				{
					ret=1;
				}
				else if(a[oldpos-i*9]!=0)
					j++;
			}
		}
		else if(y1<x1 && y2>x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*7]==100 || a[oldpos-i*7]==1 || a[oldpos-i*7]==2 || a[oldpos-i*7]==3 || a[oldpos-i*7]==4 || a[oldpos-i*7]==5 || a[oldpos-i*7]==6)
				{
					ret=1;
				}
				else if(a[oldpos-i*7]!=0)
					j++;

			}
		}
		else if(y1>x1 && y2<x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*7]==100 || a[oldpos+i*7]==1 || a[oldpos+i*7]==2 || a[oldpos+i*7]==3 || a[oldpos+i*7]==4 || a[oldpos+i*7]==5 || a[oldpos+i*7]==6)

				{
					ret=1;
				}
				else if(a[oldpos+i*7]!=0)
					j++;
			}
		}
		if(j>1)
			ret=1;
		return(ret);
	}

	public int whitequeenstraight(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;


		if(x1<y1)
		{
			for(i=1,j=0,ret=0;i<=y1-x1;i++)
			{
				if(a[oldpos+i*8]==100 || a[oldpos+i*8]==1 || a[oldpos+i*8]==2 || a[oldpos+i*8]==3 || a[oldpos+i*8]==4 || a[oldpos+i*8]==5 || a[oldpos+i*8]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i*8]==700 || a[oldpos+i*8]==7 || a[oldpos+i*8]==8 || a[oldpos+i*8]==9 || a[oldpos+i*8]==10 || a[oldpos+i*8]==11 || a[oldpos+i*8]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x1>y1)
		{
			for(i=1,j=0,ret=0;i<=x1-y1;i++)
			{
				if(a[oldpos-i*8]==100 || a[oldpos-i*8]==1 || a[oldpos-i*8]==2 || a[oldpos-i*8]==3 || a[oldpos-i*8]==4 || a[oldpos-i*8]==5 || a[oldpos-i*8]==6)

				{
					ret=1;
				}
				else if(a[oldpos-i*8]==700 || a[oldpos-i*8]==7 || a[oldpos-i*8]==8 || a[oldpos-i*8]==9 || a[oldpos-i*8]==10 || a[oldpos-i*8]==11 || a[oldpos-i*8]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}
		else if(x2<y2)
		{
			for(i=1,j=0,ret=0;i<=y2-x2;i++)
			{
				if(a[oldpos+i]==100 || a[oldpos+i]==1 || a[oldpos+i]==2 || a[oldpos+i]==3 || a[oldpos+i]==4 || a[oldpos+i]==5 || a[oldpos+i]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i]==700 || a[oldpos+i]==7 || a[oldpos+i]==8 || a[oldpos+i]==9 || a[oldpos+i]==10 || a[oldpos+i]==11 || a[oldpos+i]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x2>y2)
		{
			for(i=1,j=0,ret=0;i<=x2-y2;i++)
			{
				if(a[oldpos-i]==100 || a[oldpos-i]==1 || a[oldpos-i]==2 || a[oldpos-i]==3 || a[oldpos-i]==4 || a[oldpos-i]==5 || a[oldpos-i]==6)
				{
					ret=1;
				}
				else	if(a[oldpos-i]==700 || a[oldpos-i]==7 || a[oldpos-i]==8 || a[oldpos-i]==9 || a[oldpos-i]==10 || a[oldpos-i]==11 || a[oldpos-i]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}
		return(ret);
	}
	public int whitepawn(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if((x1+1)==y1 && x2==y2)
		{
			if(a[newpos]==0)
				ret=0;
		}
		else if((x1+1)==y1 && ((x2+1==y2)||(x2-1==y2)))
		{
			if(a[newpos]==700 || a[newpos]==7 || a[newpos]==8 || a[newpos]==9 || a[newpos]==10 || a[newpos]==11 || a[newpos]==12)
				ret=0;

		}
		return(ret);
	}

	public int whiteenpassant(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(((x1+1)==y1 || (x1+2)==y1 )&& x2==y2)
		{
			for(i=1,j=0,ret=0;i<=y1-x1;i++)
			{
				if(a[newpos]==0)
				{
					ret=0;
				}
				else 
					j++;
			}
			if(j>0)
				ret=1;
		}
		else if((x1+1)==y1 && x2==y2)
		{
			if(a[newpos]==0)
				ret=0;
		}
		else if((x1+1)==y1 && ((x2+1==y2)||(x2-1==y2)))
		{
			if(a[newpos]==700 || a[newpos]==7 || a[newpos]==8 || a[newpos]==9 || a[newpos]==10 || a[newpos]==11 || a[newpos]==12)
				ret=0;

		}
		return(ret);
	}
	public int whiteknight(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if((x1+2==y1 && x2+1==y2)||(x1+1==y1 && x2+2==y2)||(x1-2==y1 && x2-1==y2)||(x1-1==y1 && x2-2==y2)||(x1+2==y1 && x2-1==y2)||(x1+1==y1 && x2-2==y2)||(x1-2==y1 && x2+1==y2)||(x1-1==y1 && x2+2==y2))
		{
			if(a[newpos]!=100 && a[newpos]!=1 && a[newpos]!=2 && a[newpos]!=3 && a[newpos]!=4 && a[newpos]!=5 && a[newpos]!=6)
				ret=0;
		}
		return(ret);
	}
	public int whiteking(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,cast=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(wcastleking==0 && wcastlerook1==0 && y1==1 && y2==3 && a[1]==0 && a[2]==0&& a[3]==0)
		{
			cast+=whitecheck();
			a[3]=6;
			a[4]=0;
			cast+=whitecheck();
			a[3]=0;
			a[2]=6;
			cast+=whitecheck();
			a[0]=0;
			a[3]=2;
			ret=-100;
			wcastleking=2;
			wcastlerook1=2;
			if(cast!=0)
			{
				a[0]=2;
				a[1]=0;
				a[2]=0;
				a[3]=0;
				a[4]=6;
				wcastleking=0;
				wcastlerook1=0;
				ret=1;
			}
			cast=0;
		}
		else if(wcastleking==0 && wcastlerook2==0 && y1==1 && y2==7 && a[5]==0 && a[6]==0)
		{
			cast+=whitecheck();
			a[5]=6;
			a[4]=0;
			cast+=whitecheck();
			a[5]=0;
			a[6]=6;
			cast+=whitecheck();
			a[7]=0;
			a[5]=2;
			ret=-100;
			wcastleking=2;
			wcastlerook2=2;
			if(cast!=0)
			{
				a[7]=2;
				a[6]=0;
				a[5]=0;
				a[4]=6;
				ret=1;
				wcastleking=0;
				wcastlerook1=0;
			}
			cast=0;
		}
		if((x1+1==y1 && x2-1==y2 && y2!=8 && y1<=8)||(x1+1==y1 && x2==y2 && y1<=8)||(x1+1==y1 && x2+1==y2 && y1<=8 && y2<=8)||(x1==y1 && x2-1==y2 && y2!=8)||(x1==y1 && x2+1==y2 && y2<=8)||(x1-1==y1 && x2-1==y2 && y1!=8 && y2!=8)||(x1-1==y1 && x2==y2 && y1!=8)||(x1-1==y1 && x2+1==y2 && y1!=8) )
		{

			if(a[newpos]!=100 && a[newpos]!=1 && a[newpos]!=2 && a[newpos]!=3 && a[newpos]!=4 && a[newpos]!=5 && a[newpos]!=6)
				ret=0;
		}

		return(ret);
	}

	public int whitebishop(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=0,i,j=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(y1>x1 && y2>x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*9]==100 || a[oldpos+i*9]==1 || a[oldpos+i*9]==2 || a[oldpos+i*9]==3 || a[oldpos+i*9]==4 || a[oldpos+i*9]==5 || a[oldpos+i*9]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i*9]!=0)
					j++;

			}
		}

		else if(y1<x1 && y2<x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*9]==100 || a[oldpos-i*9]==1 || a[oldpos-i*9]==2 || a[oldpos-i*9]==3 || a[oldpos-i*9]==4 || a[oldpos-i*9]==5 || a[oldpos-i*9]==6)

				{
					ret=1;
				}
				else if(a[oldpos-i*9]!=0)
					j++;
			}
		}
		else if(y1<x1 && y2>x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*7]==100 || a[oldpos-i*7]==1 || a[oldpos-i*7]==2 || a[oldpos-i*7]==3 || a[oldpos-i*7]==4 || a[oldpos-i*7]==5 || a[oldpos-i*7]==6)
				{
					ret=1;
				}
				else if(a[oldpos-i*7]!=0)
					j++;

			}
		}
		else if(y1>x1 && y2<x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*7]==100 || a[oldpos+i*7]==1 || a[oldpos+i*7]==2 || a[oldpos+i*7]==3 || a[oldpos+i*7]==4 || a[oldpos+i*7]==5 || a[oldpos+i*7]==6)

				{
					ret=1;
				}
				else if(a[oldpos+i*7]!=0)
					j++;
			}
		}
		if(j>1)
			ret=1;
		return(ret);
	}




	public int whiterook(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;


		if(x1<y1)
		{
			for(i=1,j=0,ret=0;i<=y1-x1;i++)
			{
				if(a[oldpos+i*8]==100 || a[oldpos+i*8]==1 || a[oldpos+i*8]==2 || a[oldpos+i*8]==3 || a[oldpos+i*8]==4 || a[oldpos+i*8]==5 || a[oldpos+i*8]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i*8]==700 || a[oldpos+i*8]==7 || a[oldpos+i*8]==8 || a[oldpos+i*8]==9 || a[oldpos+i*8]==10 || a[oldpos+i*8]==11 || a[oldpos+i*8]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x1>y1)
		{
			for(i=1,j=0,ret=0;i<=x1-y1;i++)
			{
				if(a[oldpos-i*8]==100 || a[oldpos-i*8]==1 || a[oldpos-i*8]==2 || a[oldpos-i*8]==3 || a[oldpos-i*8]==4 || a[oldpos-i*8]==5 || a[oldpos-i*8]==6)

				{
					ret=1;
				}
				else if(a[oldpos-i*8]==700 || a[oldpos-i*8]==7 || a[oldpos-i*8]==8 || a[oldpos-i*8]==9 || a[oldpos-i*8]==10 || a[oldpos-i*8]==11 || a[oldpos-i*8]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}
		else if(x2<y2)
		{
			for(i=1,j=0,ret=0;i<=y2-x2;i++)
			{
				if(a[oldpos+i]==100 || a[oldpos+i]==1 || a[oldpos+i]==2 || a[oldpos+i]==3 || a[oldpos+i]==4 || a[oldpos+i]==5 || a[oldpos+i]==6)
				{
					ret=1;
				}
				else if(a[oldpos+i]==700 || a[oldpos+i]==7 || a[oldpos+i]==8 || a[oldpos+i]==9 || a[oldpos+i]==10 || a[oldpos+i]==11 || a[oldpos+i]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x2>y2)
		{
			for(i=1,j=0,ret=0;i<=x2-y2;i++)
			{
				if(a[oldpos-i]==100 || a[oldpos-i]==1 || a[oldpos-i]==2 || a[oldpos-i]==3 || a[oldpos-i]==4 || a[oldpos-i]==5 || a[oldpos-i]==6)
				{
					ret=1;
				}
				else	if(a[oldpos-i]==700 || a[oldpos-i]==7 || a[oldpos-i]==8 || a[oldpos-i]==9 || a[oldpos-i]==10 || a[oldpos-i]==11 || a[oldpos-i]==12)
					j++;
			}
			if(j>1)
				ret=1;
		}
		return(ret);
	}


	public int blackcheck()
	{
		int i,j,x1,x2,y1,y2,z,count=0;
		//find
		for(i=0;i<64;i++)
		{
			if(a[i]==12)
				break;
		}
		x1=b[i]/10;
		x2=b[i]%10;
		//rook & queen straight
		if(i+8<64)
		{
			for(j=i+8;j<64 && b[j]%10==x2;j+=8)
			{
				if(a[j]==2 || a[j]==5)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i-8>=0)
		{
			for(j=i-8;j>=0 && b[j]%10==x2;j-=8)
			{
				if(a[j]==2 || a[j]==5)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i-1>=0)
		{
			for(j=i-1;j>=0 && b[j]/10==x1;j--)
			{
				if(a[j]==2 || a[j]==5)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		if(i+1<64)
		{
			for(j=i+1;j<64 && b[j]/10==x1;j++)
			{
				if(a[j]==2 || a[j]==5)
					count++;
				if(a[j]!=0)
					break;
			}
		}
		//bishop & queen diagonal
		for(j=i+9,z=0;j<64 &&z==0;j+=9)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if(y2==1)
				break;
			if(a[j]==4 || a[j]==5)
				count++;
			if(y2 == 8 || y1 ==8 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i-9,z=0;j>=0 && z==0;j-=9)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if(y2==8)
				break;
			if(a[j]==4 || a[j]==5)
				count++;
			if(y2 == 0 || y1 ==0 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i+7,z=0;j<64 && z==0;j+=7)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if(y2==8)
				break;
			if(a[j]==4 || a[j]==5)
				count++;
			if(y2 == 8 || y1 ==0 )
				z++;
			if(a[j]!=0)
				break;
		}
		for(j=i-7,z=0;j>=0 && z==0;j-=7)
		{
			y1=b[j]/10;
			y2=b[j]%10;
			if(y2==1)
				break;
			if(a[j]==4 || a[j]==5)
				count++;
			if(y2 == 0 || y1 ==8 )
				z++;
			if(a[j]!=0)
				break;
		}
		//pawn
		if(i-7>=0)
		{
			y2=b[i-7]%10;
			if((a[i-7]==100||a[i-7]==1)&& y2!=8)
			{
				count++;
			}
		}
		if(i-9>=0)
		{
			y2=b[i-9]%10;
			if((a[i-9]==100||a[i-9]==1)&& y2!=1)
			{
				count++;
			}
		}

		//king
		if(i+7<64)
		{
			y2=b[i+7]%10;
			if(a[i+7]==6  && y2!=1)
				count++;
		}
		if(i-7>=0)
		{
			y2=b[i-7]%10;
			if(a[i-7]==6 && y2!=8)
				count++;
		}
		if(i+9<64)
		{
			y2=b[i+9]%10;
			if(a[i+9]==6  && y2!=8)
				count++;
		}
		if(i-9>=0)
		{
			y2=b[i-9]%10;
			if(a[i-9]==6 && y2!=1)
				count++;
		}
		if(i+8<64)
		{
			if(a[i+8]==6)
				count++;
		}
		if(i-8>=0)
		{
			if(a[i-8]==6)
				count++;
		}
		if(i-1>=0)
		{
			y2=b[i-1]%10;
			if(a[i-1]==6 && y2!=8)
				count++;
		}
		if(i+1<64)
		{
			y2=b[i+1]%10;
			if(a[i+1]==6 && y2!=1)
				count++;
		}
		//knight
		x2=b[i]%10;
		if(i+6<64)
		{
			if(a[i+6]==3 && x2>=2)
				count++;
		}
		if(i+10<64)
		{
			if(a[i+10]==3 && x2<=6)
				count++;
		}
		if(i+15<64)
		{
			if(a[i+15]==3 && x2>=1)
				count++;
		}
		if(i+17<64)
		{
			if(a[i+17]==3 && x2<=7)
				count++;
		}
		if(i-6>=0)
		{
			if(a[i-6]==3 && x2<=6)
				count++;
		}
		if(i-10>=0)
		{
			if(a[i-10]==3 && x2>=2)
				count++;
		}
		if(i-15>=0)
		{
			if(a[i-15]==3 && x2<=7)
				count++;
		}
		if(i-17>=0)
		{
			if(a[i-17]==3 && x2>=1)
				count++;
		}
		return(count);
	}



	public void blackpromotion(int newpos)
	{
		int y1;
		y1=b[newpos]/10;
		if(y1==1 && a[newpos]==7)
		{
			a[newpos]=11;
			disp();
			tv1.setText("Promotion");
		}
	}


	public int blackqueendiagonal(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=0,i,j=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(y1>x1 && y2>x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*9]==700 || a[oldpos+i*9]==7 || a[oldpos+i*9]==8 || a[oldpos+i*9]==9 || a[oldpos+i*9]==10 || a[oldpos+i*9]==11 || a[oldpos+i*9]==12)
				{
					ret=1;
					break;
				}
				else if(a[oldpos+i*9]!=0)
					j++;

			}

		}

		else if(y1<x1 && y2<x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*9]==700 || a[oldpos-i*9]==7 || a[oldpos-i*9]==8 || a[oldpos-i*9]==9 || a[oldpos-i*9]==10 || a[oldpos-i*9]==11 || a[oldpos-i*9]==12)

				{
					ret=1;
					break;
				}
				else if(a[oldpos-i*9]!=0)
					j++;
			}
		}
		else if(y1<x1 && y2>x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-(i*7)]==700 || a[oldpos-i*7]==7 || a[oldpos-i*7]==8 || a[oldpos-i*7]==9 || a[oldpos-i*7]==10 || a[oldpos-i*7]==11 || a[oldpos-i*9]==12)
				{
					ret=1;
					break;
				}
				else if(a[oldpos-(i*7)]!=0)
					j++;

			}
		}
		else if(y1>x1 && y2<x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*7]==700 || a[oldpos+i*7]==7 || a[oldpos+i*7]==8 || a[oldpos+i*7]==9 || a[oldpos+i*7]==10 || a[oldpos+i*7]==11 || a[oldpos+i*7]==12)

				{
					ret=1;
					break;
				}
				else if(a[oldpos+i*7]!=0)
					j++;
			}
		}
		if(j>1)
			ret=1;
		return(ret);
	}



	public int blackqueenstraight(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(x1<y1)
		{
			for(i=1,j=0,ret=0;i<=y1-x1;i++)
			{
				if(a[oldpos+i*8]==700 || a[oldpos+i*8]==7 || a[oldpos+i*8]==8 || a[oldpos+i*8]==9 || a[oldpos+i*8]==10 || a[oldpos+i*8]==11 || a[oldpos+i*8]==12)
				{
					ret=1;
				}
				else if(a[oldpos+i*8]==100 || a[oldpos+i*8]==1 || a[oldpos+i*8]==2 || a[oldpos+i*8]==3 || a[oldpos+i*8]==4 || a[oldpos+i*8]==5 || a[oldpos+i*8]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x1>y1)
		{
			for(i=1,j=0,ret=0;i<=x1-y1;i++)
			{
				if(a[oldpos-i*8]==700 || a[oldpos-i*8]==7 || a[oldpos-i*8]==8 || a[oldpos-i*8]==9 || a[oldpos-i*8]==10 || a[oldpos-i*8]==11 || a[oldpos-i*8]==12)
				{
					ret=1;
				}
				else if(a[oldpos-i*8]==100 || a[oldpos-i*8]==1 || a[oldpos-i*8]==2 || a[oldpos-i*8]==3 || a[oldpos-i*8]==4 || a[oldpos-i*8]==5 || a[oldpos-i*8]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}
		else if(x2<y2)
		{
			for(i=1,j=0,ret=0;i<=y2-x2;i++)
			{
				if(a[oldpos+i]==700 || a[oldpos+i]==7 || a[oldpos+i]==8 || a[oldpos+i]==9 || a[oldpos+i]==10 || a[oldpos+i]==11 || a[oldpos+i]==12)
				{
					ret=1;
				}
				else if(a[oldpos+i]==100 || a[oldpos+i]==1 || a[oldpos+i]==2 || a[oldpos+i]==3 || a[oldpos+i]==4 || a[oldpos+i]==5 || a[oldpos+i]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x2>y2)
		{
			for(i=1,j=0,ret=0;i<=x2-y2;i++)
			{
				if(a[oldpos-i]==700 || a[oldpos-i]==7 || a[oldpos-i]==8 || a[oldpos-i]==9 || a[oldpos-i]==10 || a[oldpos-i]==11 || a[oldpos-i]==12)
				{
					ret=1;
				}
				else if(a[oldpos-i]==100 || a[oldpos-i]==1 || a[oldpos-i]==2 || a[oldpos-i]==3 || a[oldpos-i]==4 || a[oldpos-i]==5 || a[oldpos-i]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}
		return(ret);
	}

	public int blackpawn(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if((x1-1)==y1 && x2==y2)
		{
			if(a[newpos]==0)
				ret=0;
		}
		else if((x1-1)==y1 && ((x2-1==y2)||(x2+1==y2)))
		{
			if(a[newpos]==100 || a[newpos]==1 || a[newpos]==2 || a[newpos]==3 || a[newpos]==4 || a[newpos]==5 || a[newpos]==6)
				ret=0;

		}
		return(ret);
	}

	public int blackenpassant(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(((x1-1)==y1 || (x1-2)==y1 )&& x2==y2)
		{
			for(i=1,j=0,ret=0;i<=x1-y1;i++)
			{
				if(a[newpos]==0)
				{
					ret=0;
				}
				else 
					j++;
			}
			if(j>0)
			{
				ret=1;
			}
		}
		else if((x1-1)==y1 && x2==y2)
		{
			if(a[newpos]==0)
				ret=0;
		}
		else if((x1-1)==y1 && ((x2-1==y2)||(x2+1==y2)))
		{
			if(a[newpos]==100 || a[newpos]==1 || a[newpos]==2 || a[newpos]==3 || a[newpos]==4 || a[newpos]==5 || a[newpos]==6)
				ret=0;

		}
		return(ret);
	}
	public int blackknight(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if((x1+2==y1 && x2+1==y2)||(x1+1==y1 && x2+2==y2)||(x1-2==y1 && x2-1==y2)||(x1-1==y1 && x2-2==y2)||(x1+2==y1 && x2-1==y2)||(x1+1==y1 && x2-2==y2)||(x1-2==y1 && x2+1==y2)||(x1-1==y1 && x2+2==y2))
		{
			if(a[newpos]!=700 && a[newpos]!=7 && a[newpos]!=8 && a[newpos]!=9 && a[newpos]!=10 && a[newpos]!=11 && a[newpos]!=12)
				ret=0;
		}
		return(ret);
	}
	public int blackking(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,cast=1;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(bcastleking==0 && bcastlerook1==0 && y1==8 && y2==3 && a[57]==0 && a[58]==0&& a[59]==0)
		{
			cast+=whitecheck();
			a[59]=6;
			a[60]=0;
			cast+=whitecheck();
			a[59]=0;
			a[58]=6;
			cast+=whitecheck();
			a[56]=0;
			a[59]=2;
			ret=-700;
			bcastleking=2;
			bcastlerook1=2;
			if(cast!=0)
			{
				a[56]=2;
				a[57]=0;
				a[58]=0;
				a[59]=0;
				a[60]=6;
				bcastleking=0;
				bcastlerook1=0;
				ret=1;
			}
			cast=0;
		}
		else if(bcastleking==0 && bcastlerook2==0 && y1==8 && y2==7 && a[61]==0 && a[62]==0)
		{
			cast+=whitecheck();
			a[61]=6;
			a[60]=0;
			cast+=whitecheck();
			a[61]=0;
			a[62]=6;
			cast+=whitecheck();
			a[63]=0;
			a[61]=2;
			ret=-700;
			bcastleking=2;
			bcastlerook2=2;
			if(cast!=0)
			{
				a[63]=2;
				a[62]=0;
				a[61]=0;
				a[60]=6;
				ret=1;
				bcastleking=0;
				bcastlerook1=0;
			}
			cast=0;
		}
		else if((x1+1==y1 && x2-1==y2)||(x1+1==y1 && x2==y2)||(x1+1==y1 && x2+1==y2)||(x1==y1 && x2-1==y2)||(x1==y1 && x2+1==y2)||(x1-1==y1 && x2-1==y2)||(x1-1==y1 && x2==y2)||(x1-1==y1 && x2+1==y2) )
		{
			if(a[newpos]!=700 && a[newpos]!=7 && a[newpos]!=8 && a[newpos]!=9 && a[newpos]!=10 && a[newpos]!=11 && a[newpos]!=12)
				ret=0;
		}
		return(ret);
	}
	public int blackbishop(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=0,i,j=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(y1>x1 && y2>x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*9]==700 || a[oldpos+i*9]==7 || a[oldpos+i*9]==8 || a[oldpos+i*9]==9 || a[oldpos+i*9]==10 || a[oldpos+i*9]==11 || a[oldpos+i*9]==12)
				{
					ret=1;
					break;
				}
				else if(a[oldpos+i*9]!=0)
					j++;

			}

		}

		else if(y1<x1 && y2<x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-i*9]==700 || a[oldpos-i*9]==7 || a[oldpos-i*9]==8 || a[oldpos-i*9]==9 || a[oldpos-i*9]==10 || a[oldpos-i*9]==11 || a[oldpos-i*9]==12)

				{
					ret=1;
					break;
				}
				else if(a[oldpos-i*9]!=0)
					j++;
			}
		}
		else if(y1<x1 && y2>x2)
		{
			for(i=1;i<=x1-y1;i++)
			{
				if(a[oldpos-(i*7)]==700 || a[oldpos-i*7]==7 || a[oldpos-i*7]==8 || a[oldpos-i*7]==9 || a[oldpos-i*7]==10 || a[oldpos-i*7]==11 || a[oldpos-i*9]==12)
				{
					ret=1;
					break;
				}
				else if(a[oldpos-(i*7)]!=0)
					j++;

			}
		}
		else if(y1>x1 && y2<x2)
		{
			for(i=1;i<=y1-x1;i++)
			{
				if(a[oldpos+i*7]==700 || a[oldpos+i*7]==7 || a[oldpos+i*7]==8 || a[oldpos+i*7]==9 || a[oldpos+i*7]==10 || a[oldpos+i*7]==11 || a[oldpos+i*7]==12)

				{
					ret=1;
					break;
				}
				else if(a[oldpos+i*7]!=0)
					j++;
			}
		}
		if(j>1)
			ret=1;
		return(ret);
	}

	public int blackrook(int oldpos,int newpos)
	{
		int x1,x2,y1,y2,ret=1,i,j;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		y1=b[newpos]/10;
		y2=b[newpos]%10;
		if(x1<y1)
		{
			for(i=1,j=0,ret=0;i<=y1-x1;i++)
			{
				if(a[oldpos+i*8]==700 || a[oldpos+i*8]==7 || a[oldpos+i*8]==8 || a[oldpos+i*8]==9 || a[oldpos+i*8]==10 || a[oldpos+i*8]==11 || a[oldpos+i*8]==12)
				{
					ret=1;
				}
				else if(a[oldpos+i*8]==100 || a[oldpos+i*8]==1 || a[oldpos+i*8]==2 || a[oldpos+i*8]==3 || a[oldpos+i*8]==4 || a[oldpos+i*8]==5 || a[oldpos+i*8]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x1>y1)
		{
			for(i=1,j=0,ret=0;i<=x1-y1;i++)
			{
				if(a[oldpos-i*8]==700 || a[oldpos-i*8]==7 || a[oldpos-i*8]==8 || a[oldpos-i*8]==9 || a[oldpos-i*8]==10 || a[oldpos-i*8]==11 || a[oldpos-i*8]==12)
				{
					ret=1;
				}
				else if(a[oldpos-i*8]==100 || a[oldpos-i*8]==1 || a[oldpos-i*8]==2 || a[oldpos-i*8]==3 || a[oldpos-i*8]==4 || a[oldpos-i*8]==5 || a[oldpos-i*8]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}
		else if(x2<y2)
		{
			for(i=1,j=0,ret=0;i<=y2-x2;i++)
			{
				if(a[oldpos+i]==700 || a[oldpos+i]==7 || a[oldpos+i]==8 || a[oldpos+i]==9 || a[oldpos+i]==10 || a[oldpos+i]==11 || a[oldpos+i]==12)
				{
					ret=1;
				}
				else if(a[oldpos+i]==100 || a[oldpos+i]==1 || a[oldpos+i]==2 || a[oldpos+i]==3 || a[oldpos+i]==4 || a[oldpos+i]==5 || a[oldpos+i]==6)
					j++;
			}
			if(j>1)
				ret=1;
		}

		else if(x2>y2)
		{
			for(i=1,j=0,ret=0;i<=x2-y2;i++)
			{
				if(a[oldpos-i]==700 || a[oldpos-i]==7 || a[oldpos-i]==8 || a[oldpos-i]==9 || a[oldpos-i]==10 || a[oldpos-i]==11 || a[oldpos-i]==12)
				{
					ret=1;
				}
				else if(a[oldpos-i]==100 || a[oldpos-i]==1 || a[oldpos-i]==2 || a[oldpos-i]==3 || a[oldpos-i]==4 || a[oldpos-i]==5 || a[oldpos-i]==6)
					j++;
			}
			if(j>0)
				ret=1;
		}
		return(ret);
	}






	public void disp()
	{
		iv1.setImageResource(piece(a[0]));
		iv2.setImageResource(piece(a[1]));
		iv3.setImageResource(piece(a[2]));
		iv4.setImageResource(piece(a[3]));
		iv5.setImageResource(piece(a[4]));
		iv6.setImageResource(piece(a[5]));
		iv7.setImageResource(piece(a[6]));
		iv8.setImageResource(piece(a[7]));
		iv9.setImageResource(piece(a[8]));
		iv10.setImageResource(piece(a[9]));
		iv11.setImageResource(piece(a[10]));
		iv12.setImageResource(piece(a[11]));
		iv13.setImageResource(piece(a[12]));
		iv14.setImageResource(piece(a[13]));
		iv15.setImageResource(piece(a[14]));
		iv16.setImageResource(piece(a[15]));
		iv17.setImageResource(piece(a[16]));
		iv18.setImageResource(piece(a[17]));
		iv19.setImageResource(piece(a[18]));	
		iv20.setImageResource(piece(a[19]));
		iv21.setImageResource(piece(a[20]));
		iv22.setImageResource(piece(a[21]));
		iv23.setImageResource(piece(a[22]));		
		iv24.setImageResource(piece(a[23]));
		iv25.setImageResource(piece(a[24]));
		iv26.setImageResource(piece(a[25]));
		iv27.setImageResource(piece(a[26]));
		iv28.setImageResource(piece(a[27]));
		iv29.setImageResource(piece(a[28]));
		iv30.setImageResource(piece(a[29]));
		iv31.setImageResource(piece(a[30]));
		iv32.setImageResource(piece(a[31]));
		iv33.setImageResource(piece(a[32]));		
		iv34.setImageResource(piece(a[33]));
		iv35.setImageResource(piece(a[34]));
		iv36.setImageResource(piece(a[35]));
		iv37.setImageResource(piece(a[36]));
		iv38.setImageResource(piece(a[37]));
		iv39.setImageResource(piece(a[38]));
		iv40.setImageResource(piece(a[39]));
		iv41.setImageResource(piece(a[40]));
		iv42.setImageResource(piece(a[41]));
		iv43.setImageResource(piece(a[42]));		
		iv44.setImageResource(piece(a[43]));
		iv45.setImageResource(piece(a[44]));
		iv46.setImageResource(piece(a[45]));
		iv47.setImageResource(piece(a[46]));
		iv48.setImageResource(piece(a[47]));
		iv49.setImageResource(piece(a[48]));
		iv50.setImageResource(piece(a[49]));
		iv51.setImageResource(piece(a[50]));
		iv52.setImageResource(piece(a[51]));
		iv53.setImageResource(piece(a[52]));		
		iv54.setImageResource(piece(a[53]));
		iv55.setImageResource(piece(a[54]));
		iv56.setImageResource(piece(a[55]));
		iv57.setImageResource(piece(a[56]));
		iv58.setImageResource(piece(a[57]));
		iv59.setImageResource(piece(a[58]));
		iv60.setImageResource(piece(a[59]));
		iv61.setImageResource(piece(a[60]));
		iv62.setImageResource(piece(a[61]));
		iv63.setImageResource(piece(a[62]));		
		iv64.setImageResource(piece(a[63]));
	}
	public int piece(int a1)
	{
		int b=0;
		switch(a1)
		{
		case 0:
			b=R.drawable.empty;
			break;
		case 1:
			b=R.drawable.white_pawn;
			break;
		case 100:
			b=R.drawable.white_pawn;
			break;
		case 2:
			b=R.drawable.white_rook;
			break;
		case 3:
			b=R.drawable.white_knight;
			break;
		case 4:
			b=R.drawable.white_bishop;
			break;
		case 5:
			b=R.drawable.white_queen;
			break;
		case 6:
			b=R.drawable.white_king;
			break;
		case 7:
			b=R.drawable.black_pawn;
			break;
		case 700:
			b=R.drawable.black_pawn;
			break;
		case 8:
			b=R.drawable.black_rook;
			break;
		case 9:
			b=R.drawable.black_knight;
			break;
		case 10:
			b=R.drawable.black_bishop;
			break;
		case 11:
			b=R.drawable.black_queen;
			break;
		case 12:
			b=R.drawable.black_king;
			break;
		}		
		return(b);	
	}



	public int charToInt(char c)
	{
		int r=0;
		if(c=='1')
			r=1;
		else if(c=='2')
			r=2;
		else if(c=='3')
			r=3;
		else if(c=='4')
			r=4;
		else if(c=='5')
			r=5;
		else if(c=='6')
			r=6;
		else if(c=='7')
			r=7;
		else if(c=='8')
			r=8;
		else if(c=='9')
			r=9;
		else if(c=='0')
			r=0;

		return r;

	}



	/**
	 * Fire an intent to start the speech recognition activity.
	 */
	private void startVoiceRecognitionActivity() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say the current move\nex:- Twenty one Move Forty one");
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
	}
	/**
	 * Handle the results from the recognition activity.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		int from=0,to=0,count=0,newpos=0,oldpos=0;
		char[] temp = new char[20];
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
			// Fill the list view with the strings the recognizer thought it could have heard
			ArrayList<String> matches = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS);


			for(int i =0;i<matches.size();++i)
			{
				temp = matches.get(i).toCharArray();
				count=0;
				if(matches.get(i).substring(0).contains("back") || matches.get(i).substring(0).contains("Back"))
				{	
					count++;
					backpressed++;
					finish();
				}
				else if(temp.length>=4)
				{
					for(int j=0;j<temp.length;++j)
					{
						if(Character.isDigit(temp[j]))
						{
							if(Character.isDigit(temp[j+1]))
							{
								int z1=0,z2=0;
								z1 = charToInt(temp[j]);
								z2 = charToInt(temp[j+1]);
								if(z1<=8 && z2<=8 && z1>0 && z2>=0)
								{
									from = z1*10 + z2;
									count++;
								}
								break;
							}
						}

					} 
					for(int j=temp.length-1;j>=0;--j)
					{
						if(Character.isDigit(temp[j]))
						{
							if(Character.isDigit(temp[j-1]))
							{
								int z1=0,z2=0;
								z1 = charToInt(temp[j-1]);
								z2 = charToInt(temp[j]);
								if(z1<=8 && z2<=8 && z1>0 && z2>=0)
								{
									to = z1*10 + z2;
									count++;
								}
								break;
							}
						}
					}
				}
				if(count==2)
					break;
				else
				{
					from=0;
					to=0;
				}
			}

			for(int i=0;i<64;i++)
			{
				if(b[i]==from)
					oldpos=i;
			}
			for(int j=0;j<64;j++)
			{
				if(b[j]==to)
					newpos=j;
			}
			if(backpressed==0)
			{
				move(oldpos,newpos);
			}

		}
		super.onActivityResult(requestCode, resultCode, data);
	}




	public int checkmate(int color)
	{
		// color
		// 1 white
		// 2 black 
		int[] c=new int[64];
		int i,j,checkmate=0;

		//c is backup
		for(i=0;i<64;i++)
		{
			c[i]=a[i];
		}

		for(i=0;i<64 && checkmate==1;i++)
		{

			for(j=0;j<64 && color==1;j++)
			{
				move(a[i],a[j] , color);
				if(whitecheck()==0)
				{
					checkmate=0;
				}

				for(i=0;i<64;i++)
				{
					a[i]=c[i];
				}
			}
			for(j=0;j<64 && color==2;j++)
			{
				move(a[i],a[j] , color);
				if(blackcheck()==0)
				{
					checkmate=0;
				}

				for(i=0;i<64;i++)
				{
					a[i]=c[i];
				}
			}

		}
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					finish();
				}

			}
		};
		if(checkmate==1 && color==1)
		{
			tv1.setText("Check & Mate Black has won");
			say("   Check & Mate . Black has won.");
			//over 9000
			generatecheckmate=9001;
			timer.start();
		}
		else if(checkmate==1 && color==2)
		{
			tv1.setText("Check & Mate White has won");
			say("   Check & Mate . White has won.");
			timer.start();
		}
		return checkmate;


	}





	public void move(int oldpos,int newpos,int color)
	{
		int x1,x2,movesucess=0,value=0;
		x1=b[oldpos]/10;
		x2=b[oldpos]%10;
		int chkr=check(oldpos,newpos);
		if(chkr==0)
		{
			if(color==1)
			{
				value=a[oldpos];

				prevoldpos=a[oldpos];
				prevnewpos=a[newpos];
				if(a[oldpos]==100 )
				{
					a[oldpos]=0;
					a[newpos]=1;

				}
				else
				{
					a[oldpos]=0;
					a[newpos]=value;

					if(x1==1 && x2==1)
					{
						wcastlerook1++;
					}
					else if(x1==1 && x2==8)
					{
						wcastlerook2++;
					}
					else if(x1==1 && x2==5)
					{
						wcastleking++;
					}
					movesucess=0;
				}	
				if(whitecheck()!=0)
				{

					a[oldpos]=prevoldpos;
					a[newpos]=prevnewpos;

					if(x1==1 && x2==1 && wcastlerook1==1)
					{
						wcastlerook1--;
					}
					else if(x1==1 && x2==8 && wcastlerook2==1)
					{
						wcastlerook2--;
					}
					else if(x1==1 && x2==5 && wcastleking==1)
					{
						wcastleking--;
					}
					movesucess=1;
				}

				if(movesucess==0)
				{
					whitepromotion(newpos);
				}
			}
		}
		else if(color==2)
		{
			prevoldpos=a[oldpos];
			prevnewpos=a[newpos];
			if(a[oldpos]==700 )
			{
				a[oldpos]=0;
				a[newpos]=7;

			}
			else
			{
				a[oldpos]=0;
				a[newpos]=value;


				if(x1==8 && x2==1)
				{
					bcastlerook1++;
				}
				else if(x1==8 && x2==8)
				{
					bcastlerook2++;
				}
				else if(x1==8 && x2==5)
				{
					bcastleking++;
				}
				movesucess=0;
			}	
			if(blackcheck()!=0)
			{

				a[oldpos]=prevoldpos;
				a[newpos]=prevnewpos;

				if(x1==8 && x2==1 && bcastlerook1==1)
				{
					bcastlerook1--;
				}
				else if(x1==8 && x2==8 && bcastlerook2==1)
				{
					bcastlerook2--;
				}
				else if(x1==8 && x2==5 && bcastleking==1)
				{
					bcastleking--;
				}
				movesucess=1;
			}
			if(movesucess==0)
			{
				blackpromotion(newpos);
			}

		}



	}






	/* put this into your activity class */
	private SensorManager mSensorManager;
	private float mAccel=0; // acceleration apart from gravity
	private float mAccelCurrent; // current acceleration including gravity
	private float mAccelLast; // last acceleration including gravity

	private final SensorEventListener mSensorListener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent se) {
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2]; 
			mAccelLast = mAccelCurrent;
			mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
			float delta = mAccelCurrent - mAccelLast;
			mAccel = mAccel * 0.9f + delta; // perform low-cut filter
			if(mAccelCurrent-mAccelLast>5)
				startVoiceRecognitionActivity();
		}

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};


	/*	public void generate()
	{
		int oldpos2,newpos2,oldpos1,newpos1,blackpts=-1,whitepts=-1,pts=0,z=0;
		for(int i=63;i>=0;i--)
		{
			for(int j=63;j>=0;j--)
			{
				if(check(i,j)==0 )
				{
					tv2.setText("inside");
					oldpos2=a[i];
					newpos2=a[j];
					a[j]=a[i];
					a[i]=0;
					if(blackcheck()==0)
					{

						if(blackpts<coinvalue(newpos2))
						{

							turn++;
							blackpts=coinvalue(newpos2);
							for(int i1=63;i1>=0;i1--)
							{
								for(int j1=63;j1>=0;j1--)
								{
									if(check(i1,j1)==0)
									{

										oldpos1=a[i1];
										newpos1=a[j1];
										a[j1]=a[i1];
										a[i1]=0;

										if(whitecheck()==0)
										{
											if(whitepts<coinvalue(newpos1))
											{
												whitepts=coinvalue(newpos1);

												if(pts<=(blackpts-whitepts))
												{
													pts=blackpts-whitepts;

													generatefrom=i;
													generateto=j;


												}

											}
										}
										a[i1]=oldpos1;
										a[j1]=newpos1;	

									}
								}
							}
							turn--;
						}
					}
					a[i]=oldpos2;
					a[j]=newpos2;
				}
			}
		}
	}  */

	/*public void generate()
	{
		int i=0,j=0,pointswhite=0,pointsblack=0,pts=0,i1;
		for( i=63;i>=0;i--)
		{
			for(j=63;j>=0;j--)
			{
				if(i!=j && check(i,j)==0 && a[i]!=0 && !(a[j]==700 ||a[j]==7||a[j]==8||a[j]==9||a[j]==10||a[j]==11||a[j]==12))
				{
					pointsblack=coinvalue(a[j]);
					turn++;
					for(i1=0,pointswhite=0;i1<64;i1++)
					{
						for(int j1=0;j1<64;j1++)
						{
							if(i1!=j1 && check(i1,j1)==0 && a[i1]!=0  && !(a[j1]==100 ||a[j1]==1||a[j1]==2||a[j1]==3||a[j1]==4||a[j1]==5||a[j1]==6))
							{
								tv3.setText("inside");
								if(pointswhite<=coinvalue(a[j1]))
								{
									pointswhite=coinvalue(a[j1]);
								}
							}
						}
					}
					if(pts<=(pointsblack-pointswhite))
					{
						pts=pointsblack-pointswhite;
						generatefrom=i;
						generateto=j;

					}
					if(pointswhite==0)
					{
						tv2.setText("zero");
					}
					else
					{
						tv3.setText("black");
					}
					turn--;
				}
			}
		}
	} */
	public void generate()
	{
		int i=0,j=0,pointsblack=0,pts=0,z4=0,oldpos2=0,newpos2=0;
		generatecheckmate=0;
		for( i=63;i>=0;i--)
		{
			for(j=63;j>=0;j--)
			{
				if(i!=j && check(i,j)==0 && a[i]!=0 && !(a[j]==700 ||a[j]==7||a[j]==8||a[j]==9||a[j]==10||a[j]==11||a[j]==12))
				{
					oldpos2=a[i];
					newpos2=a[j];
					pointsblack=coinvalue(a[j]);
					a[j]=a[i];
					a[i]=0;
					if(blackcheck()==0)
					{
						Random ran = new Random();
						int x = ran.nextInt(11) + 5;
						if(whitecheck()!=0)
						{
							tv1.setText("white in check");
							say("   Check to  White.");
							checkmate(1);
						}
						if(generatecheckmate!=0)
						{
							pointsblack=generatecheckmate;
						}
						if(pts<pointsblack)
						{
							pts=pointsblack;
							generatefrom=i;
							generateto=j;
						}
						if(pts==pointsblack && (x%6==0 || z4==0))
						{
							pts=pointsblack;
							generatefrom=i;
							generateto=j;
							z4++;
						}
					}
					a[i]=oldpos2;
					a[j]=newpos2;
				}
			}
		}
	}
	public int coinvalue(int z2)
	{
		int z1=0;
		switch(z2)
		{
		case 1:
			z1=1;
			break;
		case 100:
			z1=1;
			break;
		case 2:
			z1=5;
			break;
		case 3:
			z1=3;
			break;
		case 4:
			z1=3;
			break;
		case 5:
			z1=8;
			break;
		case 6:
			z1=1;
			break;
		case 7:
			z1=1;
			break;
		case 700:
			z1=1;
			break;
		case 8:
			z1=5;
			break;
		case 9:
			z1=3;
			break;
		case 10:
			z1=3;
			break;
		case 11:
			z1=8;
			break;
		case 12:
			z1=1;
			break;
		case 0:
			z1=0;
			break;
		}
		return(z1);
	}



	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mSensorListener);
		super.onPause();
	}

	@Override
	public void onInit(int status) {
		// status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
		if (status == TextToSpeech.SUCCESS) 
		{
			int result = mTts.setLanguage(Locale.UK);
			if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				result= mTts.setLanguage(Locale.ENGLISH);
			}
			else if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				result=mTts.setLanguage(Locale.US);
			}
			else if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) 
			{
				mTts.setLanguage(Locale.CANADA);
			}
		}
	}
	@Override
	public void onDestroy() {
		// Don't forget to shutdown!
		if (mTts != null) {
			mTts.stop();
			mTts.shutdown();
		}

		super.onDestroy();
	}
	private void say(String text)
	{
		mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
}
