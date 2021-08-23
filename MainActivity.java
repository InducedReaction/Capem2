	Rect src = null;
    Rect dst = null;
    Rect src1 = null;
    Rect dst1 = null;
    Rect backgrounddst = null;
    Rect backgroundsrc = null;

    Rect ufosrc1 = null;
    Rect beamsrc = null;
    Rect beamdst = null;
    Rect ufodst1 = null;
    Rect crosshairsrc = null;
    Rect crosshairdst = null;
    Rect cowsrc1 = null;
    Rect cowdst1 = null;
    Rect barnsrc = null;
    Rect barndst = null;
    Rect gameoversrc = null;
    Rect gameoverdst = null;
    Rect woodboardsrc = null;
    Rect woodboarddst = null;
    Rect splashsrc = null;
    Rect splashdst = null;
    Rect splash2src = null;
    Rect splash2dst = null;
    Rect shottysrc = null;
    Rect shottydst = null;
    Rect cloudsrc = null;
    Rect clouddst = null;



    var cowcycledirection = 0;
    var getufowidth=0;
    var getufoheight=0;
    var getcowheight=0;
    var shotfired=0;

    /*
    var ufosourcex1[] = {0, 198, 495, 594, 792, 990, 1188, 0, 0};
    var ufosourcey1[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    var ufosourcex2[] = {198, 495, 594, 792, 990, 1188, 1386, 0, 0};
    var ufosourcey2[] = {142, 142, 142, 142, 142, 142, 142, 142, 0};
    */



    //myRect[j] = new Rect()





    public boolean renderFlag;
    public Thread renderThread;

     Pavar drawPavar = new Pavar();

    var roll, pitch, yaw, y, x, z, w;

    var setcont=0;

    
    var bitmapwidthratio, bitmapheightratio;

    var tapX, tapY, touch;


 
 

    /**
     * Sets the view to our GvrView and initializes the transformation matrices we will use
     * to render our scene.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      

        //use for sound effects game
        sounds = new SoundPool(100, AudioManager.STREAM_MUSIC,0);
        pop = sounds.load(getBaseContext(), R.raw.gunshot, 1);
        cowsound1 = sounds.load(getBaseContext(), R.raw.cowsound1, 1);
        cowsound2 = sounds.load(getBaseContext(), R.raw.cowsound2, 1);
        explosion = sounds.load(getBaseContext(), R.raw.explosion, 1);
        beam = sounds.load(getBaseContext(), R.raw.beam, 1);


        //beam
        //cowsound1
        //cowsound2
        //explosion
        //pop
        //gunshot




        //scaling work

        //widthRatio=(width)/(2560);//1280
        //heightRatio=(height)/(1440);//720

        

        newwidthRatio=(newWidth)/(2560);//1280
        newheightRatio=(newHeight)/(1440);//720

        //image is magnified 4x
        bunnyi=0;

        //ufomirror = flip(ufo);

        src = new Rect(0, 0, bunny1.getWidth()/2, bunny1.getHeight()/2);
        dst = new Rect(0, 0, bunny1.getWidth()/2, bunny1.getHeight()/2);



    }
     

     Runnable renderingLoop = new Runnable(){

        @Override
        public void run() {
            boolean varerrupedvarernally = false;
//Run Thread
            while(!renderThread.isvarerrupted() && !varerrupedvarernally){
                try{Thread.sleep(33);}catch(varerruptedException ie){varerrupedvarernally = true;}
                if(!renderFlag)continue;



                crosshairsrc = new Rect(crosshairx1, crosshairy1, crosshairx2, crosshairy2);
                crosshairdst = new Rect( ((width/2)-Math.abs((widthRatio*(crosshairx1-crosshairx2)/2))),((height/2)-Math.abs(((crosshairy1-crosshairy2)*heightRatio)/2)) ,((width/2)+Math.abs(((crosshairx1-crosshairx2))*widthRatio/2)) ,((height/2)+Math.abs(((crosshairy1-crosshairy2)*heightRatio)/2)));

                backgroundsrc = new Rect((backgroundx1), (backgroundy1), (backgroundx2), (backgroundy2));
                backgrounddst = new Rect((0), ((((((gy)*2000)-1500)*heightRatio)-height)), (width), (((((gy*2000)-1500)*heightRatio)+(height*3))));




                

                src1 = new Rect(0, 0, (getufowidth), (getufoheight));
                dst1 = new Rect((widthRatio*((startingpovar)+(roll*1000-1000))), (heightRatio*(gy*2000+250)/bitmapheightratio), (widthRatio*((startingpovar)+(roll*1000-1000)+198)), ((heightRatio*(gy*2000+250)+142)/bitmapheightratio));

                //ufosrc1 = new Rect(ufosourcex1[ufocycle], ufosourcey1[ufocycle], ufosourcex2[ufocycle], ufosourcey2[ufocycle]);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                ufodst1 = new Rect((widthRatio*((startingpovar)+(roll*1000-1000))), (heightRatio*((gy*2000+250))), (widthRatio*((startingpovar)+(roll*1000-1000))+(396)), (heightRatio*(gy*2000+250)+(getufoheight)));

                beamsrc = new Rect(beamx1, beamy1, beamx2, beamy2);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));

                //cowsrc1 = new Rect(browncowsrcx1[cowcycle], browncowsrcy1[cowcycle], browncowsrcx2[cowcycle], browncowsrcy2[cowcycle]);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                cowdst1 = new Rect((widthRatio*((startingpovar)+(roll*1000-1000))), (heightRatio*((gy*2000+500))), (widthRatio*((startingpovar)+(roll*1000-1000))+(396)), (heightRatio*((gy*2000+500)+(getufoheight))));

                //barn stuff
                barnsrc = new Rect(barnx1, barny1, barnx2, barny2);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                barndst = new Rect((widthRatio*((startingpovar-750)+(roll*1000-1000)-(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*2)))), (heightRatio*((gy*2000+750)-((Math.abs(barny1-barny2)/bitmapheightratio)*2))), (widthRatio*((startingpovar-750)+(roll*1000-1000))+(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*2))), (heightRatio*(gy*2000+750)+((Math.abs(barny1-barny2)/bitmapheightratio)*2)));

                //gameover stuff
                gameoversrc = new Rect(gameoverx1, gameovery1, gameoverx2, gameovery2);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                gameoverdst = new Rect((width*.25), (height*.1), (width*.75), (height*.4));






                //gameover stuff

                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                //gameoverdst = new Rect((width*.25), (height*.25), (width*.75), (height*.75));



                //cloud stuff
                cloudsrc = new Rect(cloudx1, cloudy1, cloudx2, cloudy2);
                //ufodst1 = new Rect(((startingpovar)+(roll*1000-1000)), ((gy*2000+250)), ((startingpovar)+(roll*1000-1000))+(396), (gy*2000+250)+(getufoheight));
                clouddst =  new Rect((widthRatio*((startingpovar)+(roll*1000-500)-(((Math.abs(cloudx1-cloudx2))/2)))), (heightRatio*((gy*2000)-((Math.abs(cloudy1-cloudy2))/2))), (widthRatio*((startingpovar)+(roll*1000-500))+(((Math.abs(cloudx1-cloudx2))/2))), (heightRatio*(gy*2000)+((Math.abs(cloudy1-cloudy2))/2)));





                //If it's at the tap povar stop...
                //var dx = tapX - (carPosX + bmpRectSrc.right/2);
                //var dy = tapY - (carPosY + bmpRectSrc.bottom);
                //var dist = Math.sqrt(dx * dx + dy * dy);
				/*if(dist <= bmpRectSrc.bottom/2){
					renderFlag = false;
					continue;
				}
				*/
                //Set the proper dst rectangle for the bmp...
                //bmpRectDst.left = carPosX;
                //bmpRectDst.top = carPosY;
                //bmpRectDst.right = bmpRectDst.left + bmpRectSrc.right;
                //bmpRectDst.bottom = bmpRectDst.top + bmpRectSrc.bottom;
                //Drawing logic...

                try{



                    


                    Canvas canvas = surfaceHolder.lockCanvas();
                    canvas.drawRGB(0, 112, 130);//clearcanvas
                    //this one is for the background


                    canvas.save();
                    
                    
                    canvas.drawBitmap(ufo, backgroundsrc, backgrounddst, null);
                    canvas.restore();

                    //this one is for the Barn
                    canvas.save();

                    
                    barndst = new Rect((widthRatio*((startingpovar-750)+(roll1*1000-1000)-(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3)))), (heightRatio*((gy1*2000+750)-((Math.abs(barny1-barny2)/bitmapheightratio)*.3))), (widthRatio*((startingpovar-750)+(roll1*1000-1000))+(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3))), (heightRatio*(gy1*2000+750)+((Math.abs(barny1-barny2)/bitmapheightratio)*.3)));

                    canvas.drawBitmap(ufo, barnsrc, barndst, null);
                    canvas.restore();

                    canvas.save();

                    
					barndst = new Rect((widthRatio*((startingpovar-750)+((roll1+(Math.PI*2))*1000-1000)-(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3)))), (heightRatio*((gy1*2000+750)-((Math.abs(barny1-barny2)/bitmapheightratio)*.3))), (widthRatio*((startingpovar-750)+((roll1+(Math.PI*2))*1000-1000))+(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3))), (heightRatio*(gy1*2000+750)+((Math.abs(barny1-barny2)/bitmapheightratio)*.3)));

                    canvas.drawBitmap(ufo, barnsrc, barndst, null);
                    canvas.restore();

                    canvas.save();

                    
                    barndst = new Rect((widthRatio*((startingpovar-750)+((roll1-(Math.PI*2))*1000-1000)-(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3)))), (heightRatio*((gy1*2000+750)-((Math.abs(barny1-barny2)/bitmapheightratio)*.3))), (widthRatio*((startingpovar-750)+((roll1-(Math.PI*2))*1000-1000))+(((Math.abs(barnx1-barnx2)/bitmapwidthratio)*.3))), (heightRatio*(gy1*2000+750)+((Math.abs(barny1-barny2)/bitmapheightratio)*.3)));

                    canvas.drawBitmap(ufo, barnsrc, barndst, null);
                    canvas.restore();


                    //this one is for the Cloud
                    canvas.save();
                    

                    clouddst =  new Rect((widthRatio*((startingpovar)+(roll1*1000-500)-(((Math.abs(cloudx1-cloudx2))/2)))), (heightRatio*((gy1*2000)-((Math.abs(cloudy1-cloudy2))/2))), (widthRatio*((startingpovar)+(roll1*1000-500))+(((Math.abs(cloudx1-cloudx2))/2))), (heightRatio*(gy1*2000)+((Math.abs(cloudy1-cloudy2))/2)));

                    canvas.drawBitmap(ufo, cloudsrc, clouddst, null);
                    canvas.restore();


                    canvas.save();
                    

                    clouddst =  new Rect((widthRatio*((startingpovar)+((roll1-(Math.PI*2))*1000-500)-(((Math.abs(cloudx1-cloudx2))/2)))), (heightRatio*((gy1*2000)-((Math.abs(cloudy1-cloudy2))/2))), (widthRatio*((startingpovar)+((roll1-(Math.PI*2))*1000-500))+(((Math.abs(cloudx1-cloudx2))/2))), (heightRatio*(gy1*2000)+((Math.abs(cloudy1-cloudy2))/2)));

                    canvas.drawBitmap(ufo, cloudsrc, clouddst, null);
                    canvas.restore();

                    canvas.save();
                    

                    clouddst =  new Rect((widthRatio*((startingpovar)+((roll1+(Math.PI*2))*1000-500)-(((Math.abs(cloudx1-cloudx2))/2)))), (heightRatio*((gy1*2000)-((Math.abs(cloudy1-cloudy2))/2))), (widthRatio*((startingpovar)+((roll1+(Math.PI*2))*1000-500))+(((Math.abs(cloudx1-cloudx2))/2))), (heightRatio*(gy1*2000)+((Math.abs(cloudy1-cloudy2))/2)));

                    canvas.drawBitmap(ufo, cloudsrc, clouddst, null);
                    canvas.restore();


                    Pavar pavar = new Pavar();
                    Pavar pavar1 = new Pavar();
                    pavar1.setAlpha(70); // you can change number to change the transparency level
                    //pavar.setColor(Color.WHITE);
                    //pavar.setStyle(Style.FILL);
                    //canvas.drawPavar(pavar);

                    pavar.setColor(Color.RED);
                    pavar.setTextSize( (1920/32));
                    //canvas.drawText("x "+headRotation[0]+" ufo width" + ufo.getWidth(), (10), (60), pavar);//top left is level
                    //canvas.drawText("rise "+rise+" run" + run, (10), (60), pavar);//top left is level
                    //canvas.drawText("y "+headRotation[1]+" ufo height" + ufo.getHeight(), (10), (120), pavar);//top left is level
                    //canvas.drawText("ufopatter0 "+ufopattern[0]+" cowcycle0" + cowcycle[0]+"cowcolor0"+cowcolor[0], (10), (120), pavar);//top left is level
                    //canvas.drawText("z "+headRotation[2]+" screen height"+height, (10), (180), pavar);//top left is level
                    //canvas.drawText("ufopattern1 "+ufopattern[1]+" cowcycle1"+cowcycle[1]+"cowcolor1"+cowcolor[1], (10), (180), pavar);//top left is level
                    //canvas.drawText("w "+headRotation[3]+ " screen widht"+ width, (10), (240), pavar);//top left is level
                    //canvas.drawText("cowstate2 "+cowstate[2]+ " cowcycle2"+ cowcycle[2]+"cowcolor2"+cowcolor[2], (10), (240), pavar);//top left is level

                    //canvas.drawText("roll1 "+roll1, (10), (300), pavar);//top left is level
                    //canvas.drawText("cowstate3 "+cowstate[3]+"cowcycle3"+cowcycle[3]+"cowcolor3"+cowcolor[3], (10), (300), pavar);//top left is level
                    //canvas.drawText("pitch "+pitch, (10), (360), pavar);//top left is level
                    //canvas.drawText("gravity"+gy1, (10), (360), pavar);//top left is level

                    //canvas.drawText("bunnyi "+bunnyi+"bitmapwidth"+bitmapwidthratio+"bitmapheight"+bitmapheightratio, (10), (480), pavar);//top left is level


                    //canvas.drawText("yaw "+yaw, (10), (420), pavar);//top left is level


                    //canvas.drawText("tapX "+tapX, (10), (320+500), pavar);//top left is level
                    //canvas.drawText("tapY "+ufo.getWidth(), (10), (400+500), pavar);//top left is level

                    //headRotation[1]*2000+350
                    //canvas.drawBitmap(bird, startingpovar+(roll1*1000-1000), gy1*2000+350, null);



                            //canvas.drawBitmap(bunny1, roll1*1000-1000, gy1*2000+650, null);


                    //canvas.drawBitmap(bunny, roll1*1000-1000, gy1*2000+650, null);

                    // canvas.drawBitmap(ufo, roll1*1000-1000, gy1*2000+250, null);

                    //canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);

                    //canvas.restore();






                    //this one is for cows
                    for(var i=0; i<cowscount; i++){






                        if(cowstate[i]==0) {




                            cowsrc1 = new Rect(cowsrcx1[cowcycle[i]], cowsrcy1[cowcycle[i]], cowsrcx2[cowcycle[i]], cowsrcy2[cowcycle[i]]);

                            canvas.save();
                            
                            
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            canvas.restore();
                        }else if(cowstate[i]==1) {

                            if(cowcolor[i]==0){

                                cowsrc1 = new Rect(cowsrcx1[10], cowsrcy1[10], cowsrcx2[10], cowsrcy2[10]);

                            }
                            if(cowcolor[i]==1){
                                cowsrc1 = new Rect(cowsrcx1[21], cowsrcy1[21], cowsrcx2[21], cowsrcy2[21]);
                            }
                            if(cowcolor[i]==2){
                                cowsrc1 = new Rect(cowsrcx1[22], cowsrcy1[22], cowsrcx2[22], cowsrcy2[22]);
                            }
                            if(cowcolor[i]==3){
                                cowsrc1 = new Rect(cowsrcx1[33], cowsrcy1[33], cowsrcx2[33], cowsrcy2[33]);
                            }




                            //cowsrc1 = new Rect(cowsrcx1[cowcycle[i]], cowsrcy1[cowcycle[i]], cowsrcx2[cowcycle[i]], cowsrcy2[cowcycle[i]]);

                            canvas.save();
                            
                          
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000 + cowx[i]))),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]))),  (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000 + cowx[i] )) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[i]) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            canvas.restore();
                        }

                        /*else if(cowstate[i]==1){

                            cowsrc1 = new Rect(cowsrcx1[cowcycle[i]], cowsrcy1[cowcycle[i]], cowsrcx2[cowcycle[i]], cowsrcy2[cowcycle[i]]);
                            //cowstate[i]++;
                            canvas.save();
                            
                            
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000))),  (heightRatio * ((gy1 * 2000 + 500))),  (widthRatio * ((startingpovar) + (roll1 * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000))),  (heightRatio * ((gy1 * 2000 + 500))),  (widthRatio * ((startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);

                            cowdst1 = new Rect( (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000))),  (heightRatio * ((gy1 * 2000 + 500))),  (widthRatio * ((startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500) + (getufoheight))));

                            canvas.drawBitmap(ufo, cowsrc1, cowdst1, null);
                            canvas.restore();

                        }
                        */
                    }


                    //this one is for ufos
                    for(var i=ufoscount-1; i>=0; i--){
                        if(ufostate[i]==0) {
                            //drawing each bird
                            canvas.save();
                            
                            if(ufoabducting[i]==1){
                                beamdst = new Rect( (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000))),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (getufoheight/2)),  (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[(ufovictim[i])]) + (getufoheight))));
                                //still need to change the x2 and y2 of the beam to the cow's y
                                canvas.drawBitmap(ufo, beamsrc, beamdst, pavar1);

                                beamdst = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (getufoheight/2)),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[(ufovictim[i])]) + (getufoheight))));
                                //still need to change the x2 and y2 of the beam to the cow's y
                                canvas.drawBitmap(ufo, beamsrc, beamdst, pavar1);

                                beamdst = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (getufoheight/2)),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000)) + (396)),  (heightRatio * ((gy1 * 2000 + 500 + cowy[(ufovictim[i])]) + (getufoheight))));
                                //still need to change the x2 and y2 of the beam to the cow's y
                                canvas.drawBitmap(ufo, beamsrc, beamdst, pavar1);

                            }
                            var newcrazyangle;// = 0;
                            if(ufopattern[i]==4){
                                newcrazyangle =  (0-Math.toDegrees((double)(ufoflightdirectiontheta[i])));
                            }else if(ufopattern[i]==3){
                                newcrazyangle =  (0-Math.toDegrees((double)(ufoflightdirectiontheta[i])));
                            }else{
                                newcrazyangle = 0;
                            }

                            canvas.rotate(newcrazyangle,  (ufox[i]+widthRatio * ((startingpovar) + (roll1 * 1000 - 1000))) + (396 / 2),  (ufoy[i]+heightRatio * (gy1 * 2000 + 250) + (getufoheight / 2)));

                          if(ufocolor[i]==0){
                              ufosourcex1[0] =  (0*bitmapwidthratio);
                              ufosourcex1[1] =  (400*bitmapwidthratio);
                              ufosourcex1[2] =  (800*bitmapwidthratio);
                              ufosourcex1[3] =  (1200*bitmapwidthratio);
                              ufosourcex1[4] =  (1600*bitmapwidthratio);
                              ufosourcex1[5] =  (2000*bitmapwidthratio);
                              ufosourcex1[6] =  (2400*bitmapwidthratio);
                              ufosourcex1[7] =  (2800*bitmapwidthratio);
                              ufosourcex1[8] =  (3200*bitmapwidthratio);
                              ufosourcex1[9] =  (3600*bitmapwidthratio);
                              ufosourcex1[10] =  (4000*bitmapwidthratio);
                              ufosourcex1[11] =  (4400*bitmapwidthratio);
                              ufosourcex1[12] =  (5328*bitmapwidthratio);
                              ufosourcex1[13] =  (5772*bitmapwidthratio);

                              ufosourcex2[0] =  (396*bitmapwidthratio);
                              ufosourcex2[1] =  (796*bitmapwidthratio);
                              ufosourcex2[2] =  (1196*bitmapwidthratio);
                              ufosourcex2[3] =  (1596*bitmapwidthratio);
                              ufosourcex2[4] =  (1996*bitmapwidthratio);
                              ufosourcex2[5] =  (2396*bitmapwidthratio);
                              ufosourcex2[6] =  (2796*bitmapwidthratio);
                              ufosourcex2[7] =  (3196*bitmapwidthratio);
                              ufosourcex2[8] =  (3596*bitmapwidthratio);
                              ufosourcex2[9] =  (3996*bitmapwidthratio);
                              ufosourcex2[10] =  (4396*bitmapwidthratio);
                              ufosourcex2[11] =  (4796*bitmapwidthratio);
                              ufosourcex2[12] =  (5772*bitmapwidthratio);
                              ufosourcex2[13] =  (6216*bitmapwidthratio);



                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=0;
                                    ufosourcey2[tbc]=248;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }
                            else if(ufocolor[i]==1){
                              ufosourcex1[0] =  (0*bitmapwidthratio);
                              ufosourcex1[1] =  (400*bitmapwidthratio);
                              ufosourcex1[2] =  (800*bitmapwidthratio);
                              ufosourcex1[3] =  (1200*bitmapwidthratio);
                              ufosourcex1[4] =  (1600*bitmapwidthratio);
                              ufosourcex1[5] =  (2000*bitmapwidthratio);
                              ufosourcex1[6] =  (2400*bitmapwidthratio);
                              ufosourcex1[7] =  (2800*bitmapwidthratio);
                              ufosourcex1[8] =  (3200*bitmapwidthratio);
                              ufosourcex1[9] =  (3600*bitmapwidthratio);
                              ufosourcex1[10] =  (4000*bitmapwidthratio);
                              ufosourcex1[11] =  (4400*bitmapwidthratio);
                              ufosourcex1[12] =  (5328*bitmapwidthratio);
                              ufosourcex1[13] =  (5772*bitmapwidthratio);

                              ufosourcex2[0] =  (396*bitmapwidthratio);
                              ufosourcex2[1] =  (796*bitmapwidthratio);
                              ufosourcex2[2] =  (1196*bitmapwidthratio);
                              ufosourcex2[3] =  (1596*bitmapwidthratio);
                              ufosourcex2[4] =  (1996*bitmapwidthratio);
                              ufosourcex2[5] =  (2396*bitmapwidthratio);
                              ufosourcex2[6] =  (2796*bitmapwidthratio);
                              ufosourcex2[7] =  (3196*bitmapwidthratio);
                              ufosourcex2[8] =  (3596*bitmapwidthratio);
                              ufosourcex2[9] =  (3996*bitmapwidthratio);
                              ufosourcex2[10] =  (4396*bitmapwidthratio);
                              ufosourcex2[11] =  (4796*bitmapwidthratio);
                              ufosourcex2[12] =  (5772*bitmapwidthratio);
                              ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=3700;
                                    ufosourcey2[tbc]=3948;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==2){
                              ufosourcex1[0] =  (0*bitmapwidthratio);
                              ufosourcex1[1] =  (400*bitmapwidthratio);
                              ufosourcex1[2] =  (800*bitmapwidthratio);
                              ufosourcex1[3] =  (1200*bitmapwidthratio);
                              ufosourcex1[4] =  (1600*bitmapwidthratio);
                              ufosourcex1[5] =  (2000*bitmapwidthratio);
                              ufosourcex1[6] =  (2400*bitmapwidthratio);
                              ufosourcex1[7] =  (2800*bitmapwidthratio);
                              ufosourcex1[8] =  (3200*bitmapwidthratio);
                              ufosourcex1[9] =  (3600*bitmapwidthratio);
                              ufosourcex1[10] =  (4000*bitmapwidthratio);
                              ufosourcex1[11] =  (4400*bitmapwidthratio);
                              ufosourcex1[12] =  (5328*bitmapwidthratio);
                              ufosourcex1[13] =  (5772*bitmapwidthratio);

                              ufosourcex2[0] =  (396*bitmapwidthratio);
                              ufosourcex2[1] =  (796*bitmapwidthratio);
                              ufosourcex2[2] =  (1196*bitmapwidthratio);
                              ufosourcex2[3] =  (1596*bitmapwidthratio);
                              ufosourcex2[4] =  (1996*bitmapwidthratio);
                              ufosourcex2[5] =  (2396*bitmapwidthratio);
                              ufosourcex2[6] =  (2796*bitmapwidthratio);
                              ufosourcex2[7] =  (3196*bitmapwidthratio);
                              ufosourcex2[8] =  (3596*bitmapwidthratio);
                              ufosourcex2[9] =  (3996*bitmapwidthratio);
                              ufosourcex2[10] =  (4396*bitmapwidthratio);
                              ufosourcex2[11] =  (4796*bitmapwidthratio);
                              ufosourcex2[12] =  (5772*bitmapwidthratio);
                              ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=3960;
                                    ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==3){
                              ufosourcex1[0] =  (0*bitmapwidthratio);
                              ufosourcex1[1] =  (400*bitmapwidthratio);
                              ufosourcex1[2] =  (800*bitmapwidthratio);
                              ufosourcex1[3] =  (1200*bitmapwidthratio);
                              ufosourcex1[4] =  (1600*bitmapwidthratio);
                              ufosourcex1[5] =  (2000*bitmapwidthratio);
                              ufosourcex1[6] =  (2400*bitmapwidthratio);
                              ufosourcex1[7] =  (2800*bitmapwidthratio);
                              ufosourcex1[8] =  (3200*bitmapwidthratio);
                              ufosourcex1[9] =  (3600*bitmapwidthratio);
                              ufosourcex1[10] =  (4000*bitmapwidthratio);
                              ufosourcex1[11] =  (4400*bitmapwidthratio);
                              ufosourcex1[12] =  (5328*bitmapwidthratio);
                              ufosourcex1[13] =  (5772*bitmapwidthratio);

                              ufosourcex2[0] =  (396*bitmapwidthratio);
                              ufosourcex2[1] =  (796*bitmapwidthratio);
                              ufosourcex2[2] =  (1196*bitmapwidthratio);
                              ufosourcex2[3] =  (1596*bitmapwidthratio);
                              ufosourcex2[4] =  (1996*bitmapwidthratio);
                              ufosourcex2[5] =  (2396*bitmapwidthratio);
                              ufosourcex2[6] =  (2796*bitmapwidthratio);
                              ufosourcex2[7] =  (3196*bitmapwidthratio);
                              ufosourcex2[8] =  (3596*bitmapwidthratio);
                              ufosourcex2[9] =  (3996*bitmapwidthratio);
                              ufosourcex2[10] =  (4396*bitmapwidthratio);
                              ufosourcex2[11] =  (4796*bitmapwidthratio);
                              ufosourcex2[12] =  (5772*bitmapwidthratio);
                              ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //Red Bird source y1=4220; y2=4468;
                                    //White Bird source y1=4488; y2=4736;
                                    //Green Bird source y1=4748; y2=4996;
                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4220;
                                    ufosourcey2[tbc]=4468;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==4){
                              ufosourcex1[0] =  (0*bitmapwidthratio);
                              ufosourcex1[1] =  (400*bitmapwidthratio);
                              ufosourcex1[2] =  (800*bitmapwidthratio);
                              ufosourcex1[3] =  (1200*bitmapwidthratio);
                              ufosourcex1[4] =  (1600*bitmapwidthratio);
                              ufosourcex1[5] =  (2000*bitmapwidthratio);
                              ufosourcex1[6] =  (2400*bitmapwidthratio);
                              ufosourcex1[7] =  (2800*bitmapwidthratio);
                              ufosourcex1[8] =  (3200*bitmapwidthratio);
                              ufosourcex1[9] =  (3600*bitmapwidthratio);
                              ufosourcex1[10] =  (4000*bitmapwidthratio);
                              ufosourcex1[11] =  (4400*bitmapwidthratio);
                              ufosourcex1[12] =  (5328*bitmapwidthratio);
                              ufosourcex1[13] =  (5772*bitmapwidthratio);

                              ufosourcex2[0] =  (396*bitmapwidthratio);
                              ufosourcex2[1] =  (796*bitmapwidthratio);
                              ufosourcex2[2] =  (1196*bitmapwidthratio);
                              ufosourcex2[3] =  (1596*bitmapwidthratio);
                              ufosourcex2[4] =  (1996*bitmapwidthratio);
                              ufosourcex2[5] =  (2396*bitmapwidthratio);
                              ufosourcex2[6] =  (2796*bitmapwidthratio);
                              ufosourcex2[7] =  (3196*bitmapwidthratio);
                              ufosourcex2[8] =  (3596*bitmapwidthratio);
                              ufosourcex2[9] =  (3996*bitmapwidthratio);
                              ufosourcex2[10] =  (4396*bitmapwidthratio);
                              ufosourcex2[11] =  (4796*bitmapwidthratio);
                              ufosourcex2[12] =  (5772*bitmapwidthratio);
                              ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4488;
                                    ufosourcey2[tbc]=4736;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==5){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                //Black Bird source y1=0; y2=248;
                                //Blue Bird source y1=3700; y2=3948;
                                //Yellow Bird source y1=3960; y2=4208;
                                //Red Bird source y1=4220; y2=4468;
                                //White Bird source y1=4488; y2=4736;
                                //Green Bird source y1=4748; y2=4996;

                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4748;
                                    ufosourcey2[tbc]=4996;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==6){
                                //Black Bird source y1=0; y2=248;
                                //Blue Bird source y1=3700; y2=3948;
                                //Yellow Bird source y1=3960; y2=4208;
                                //Red Bird source y1=4220; y2=4468;
                                //White Bird source y1=4488; y2=4736;
                                //Green Bird source y1=4748; y2=4996;

                                //CHANGE THESE FOR THE BUNNY
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (444*bitmapwidthratio);
                                ufosourcex1[2] =  (888*bitmapwidthratio);
                                ufosourcex1[3] =  (1332*bitmapwidthratio);
                                ufosourcex1[4] =  (1776*bitmapwidthratio);
                                ufosourcex1[5] =  (2220*bitmapwidthratio);
                                ufosourcex1[6] =  (2664*bitmapwidthratio);
                                ufosourcex1[7] =  (3108*bitmapwidthratio);
                                ufosourcex1[8] =  (3552*bitmapwidthratio);
                                ufosourcex1[9] =  (3996*bitmapwidthratio);
                                ufosourcex1[10] =  (4440*bitmapwidthratio);
                                ufosourcex1[11] =  (4884*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);


                                ufosourcex2[0] =  (444*bitmapwidthratio);
                                ufosourcex2[1] =  (888*bitmapwidthratio);
                                ufosourcex2[2] =  (1332*bitmapwidthratio);
                                ufosourcex2[3] =  (1776*bitmapwidthratio);
                                ufosourcex2[4] =  (2220*bitmapwidthratio);
                                ufosourcex2[5] =  (2664*bitmapwidthratio);
                                ufosourcex2[6] =  (3108*bitmapwidthratio);
                                ufosourcex2[7] =  (3552*bitmapwidthratio);
                                ufosourcex2[8] =  (3996*bitmapwidthratio);
                                ufosourcex2[9] =  (4440*bitmapwidthratio);
                                ufosourcex2[10] =  (4884*bitmapwidthratio);
                                ufosourcex2[11] =  (5328*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);


                                for(var tbc=0; tbc<=13; tbc++){


                                    ufosourcey1[tbc]=5000;
                                    ufosourcey2[tbc]=5416;


                                }
                            }
                            if(ufocycle[i]>13){

                                canvas.drawText("UfoSource 13 "+ufocycle[i] +"color "+ufocolor[i], (300*widthRatio), (60*heightRatio), pavar);//top left is level
                            }

                            ufosrc1 = new Rect(ufosourcex1[ufocycle[i]], ufosourcey1[ufocycle[i]], ufosourcex2[ufocycle[i]], ufosourcey2[ufocycle[i]]);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));
                            //
                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));
                            //
                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));
                            //
                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            canvas.restore();
                        }else if(ufostate[i]>=1&&ufostate[i]<10){
                            //exploding ufo
                            ufostate[i]++;
                            canvas.save();
                            
                            canvas.rotate( (Math.random()*360),  (((widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000))))+((widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000)) + (targetwidth[i]))))/2,  (((heightRatio * (ufoy[i]+(gy1 * 2000 + 250)))+(heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])))/2));

                            //Black Bird source y1=0; y2=248;
                            //Blue Bird source y1=3700; y2=3948;
                            //Yellow Bird source y1=3960; y2=4208;
                            //Red Bird source y1=4220; y2=4468;
                            //White Bird source y1=4488; y2=4736;
                            //Green Bird source y1=4748; y2=4996;
                            if(ufocolor[i]==0){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);



                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=0;
                                    ufosourcey2[tbc]=248;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }
                            else if(ufocolor[i]==1){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=3700;
                                    ufosourcey2[tbc]=3948;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==2){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=3960;
                                    ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==3){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //Red Bird source y1=4220; y2=4468;
                                    //White Bird source y1=4488; y2=4736;
                                    //Green Bird source y1=4748; y2=4996;
                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4220;
                                    ufosourcey2[tbc]=4468;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==4){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4488;
                                    ufosourcey2[tbc]=4736;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==5){
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (400*bitmapwidthratio);
                                ufosourcex1[2] =  (800*bitmapwidthratio);
                                ufosourcex1[3] =  (1200*bitmapwidthratio);
                                ufosourcex1[4] =  (1600*bitmapwidthratio);
                                ufosourcex1[5] =  (2000*bitmapwidthratio);
                                ufosourcex1[6] =  (2400*bitmapwidthratio);
                                ufosourcex1[7] =  (2800*bitmapwidthratio);
                                ufosourcex1[8] =  (3200*bitmapwidthratio);
                                ufosourcex1[9] =  (3600*bitmapwidthratio);
                                ufosourcex1[10] =  (4000*bitmapwidthratio);
                                ufosourcex1[11] =  (4400*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);

                                ufosourcex2[0] =  (396*bitmapwidthratio);
                                ufosourcex2[1] =  (796*bitmapwidthratio);
                                ufosourcex2[2] =  (1196*bitmapwidthratio);
                                ufosourcex2[3] =  (1596*bitmapwidthratio);
                                ufosourcex2[4] =  (1996*bitmapwidthratio);
                                ufosourcex2[5] =  (2396*bitmapwidthratio);
                                ufosourcex2[6] =  (2796*bitmapwidthratio);
                                ufosourcex2[7] =  (3196*bitmapwidthratio);
                                ufosourcex2[8] =  (3596*bitmapwidthratio);
                                ufosourcex2[9] =  (3996*bitmapwidthratio);
                                ufosourcex2[10] =  (4396*bitmapwidthratio);
                                ufosourcex2[11] =  (4796*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);
                                //Black Bird source y1=0; y2=248;
                                //Blue Bird source y1=3700; y2=3948;
                                //Yellow Bird source y1=3960; y2=4208;
                                //Red Bird source y1=4220; y2=4468;
                                //White Bird source y1=4488; y2=4736;
                                //Green Bird source y1=4748; y2=4996;

                                for(var tbc=0; tbc<13; tbc++){

                                    //ufosourcey1[tbc]=4220;//1055
                                    //ufosourcey2[tbc]=4468;//1117
                                    //ufosourcey1[tbc]=4488;
                                    //ufosourcey2[tbc]=4736;
                                    ufosourcey1[tbc]=4748;
                                    ufosourcey2[tbc]=4996;
                                    //ufosourcey1[tbc]=3960;
                                    //ufosourcey2[tbc]=4208;
                                    //ufosourcey1[tbc]=4748;
                                    //ufosourcey2[tbc]=4996;

                                }
                            }else if(ufocolor[i]==6){
                                //Black Bird source y1=0; y2=248;
                                //Blue Bird source y1=3700; y2=3948;
                                //Yellow Bird source y1=3960; y2=4208;
                                //Red Bird source y1=4220; y2=4468;
                                //White Bird source y1=4488; y2=4736;
                                //Green Bird source y1=4748; y2=4996;

                                //CHANGE THESE FOR THE BUNNY
                                ufosourcex1[0] =  (0*bitmapwidthratio);
                                ufosourcex1[1] =  (444*bitmapwidthratio);
                                ufosourcex1[2] =  (888*bitmapwidthratio);
                                ufosourcex1[3] =  (1332*bitmapwidthratio);
                                ufosourcex1[4] =  (1776*bitmapwidthratio);
                                ufosourcex1[5] =  (2220*bitmapwidthratio);
                                ufosourcex1[6] =  (2664*bitmapwidthratio);
                                ufosourcex1[7] =  (3108*bitmapwidthratio);
                                ufosourcex1[8] =  (3552*bitmapwidthratio);
                                ufosourcex1[9] =  (3996*bitmapwidthratio);
                                ufosourcex1[10] =  (4440*bitmapwidthratio);
                                ufosourcex1[11] =  (4884*bitmapwidthratio);
                                ufosourcex1[12] =  (5328*bitmapwidthratio);
                                ufosourcex1[13] =  (5772*bitmapwidthratio);


                                ufosourcex2[0] =  (444*bitmapwidthratio);
                                ufosourcex2[1] =  (888*bitmapwidthratio);
                                ufosourcex2[2] =  (1332*bitmapwidthratio);
                                ufosourcex2[3] =  (1776*bitmapwidthratio);
                                ufosourcex2[4] =  (2220*bitmapwidthratio);
                                ufosourcex2[5] =  (2664*bitmapwidthratio);
                                ufosourcex2[6] =  (3108*bitmapwidthratio);
                                ufosourcex2[7] =  (3552*bitmapwidthratio);
                                ufosourcex2[8] =  (3996*bitmapwidthratio);
                                ufosourcex2[9] =  (4440*bitmapwidthratio);
                                ufosourcex2[10] =  (4884*bitmapwidthratio);
                                ufosourcex2[11] =  (5328*bitmapwidthratio);
                                ufosourcex2[12] =  (5772*bitmapwidthratio);
                                ufosourcex2[13] =  (6216*bitmapwidthratio);


                                for(var tbc=0; tbc<=13; tbc++){


                                    ufosourcey1[tbc]=5020;
                                    ufosourcey2[tbc]=5416;


                                }
                            }

                            ufosrc1 = new Rect(ufosourcex1[8], ufosourcey1[8], ufosourcex2[8], ufosourcey2[8]);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + (roll1 * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));

                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1+(Math.PI*2)) * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));

                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            ufodst1 = new Rect( (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000))),  (heightRatio * (ufoy[i]+(gy1 * 2000 + 250))),  (widthRatio * (ufox[i]+(startingpovar) + ((roll1-(Math.PI*2)) * 1000 - 1000)) + (targetwidth[i])),  (heightRatio * (gy1 * 2000 + 250) + ufoy[i]+ (targetheight[i])));

                            canvas.drawBitmap(ufo, ufosrc1, ufodst1, null);
                            canvas.restore();
                        }
                    }







                    //canvas.drawBitmap(bunny1, src, dst, null);

                            //canvas.drawBitmap(bunny1, roll1*1000-1000, gy1*2000+650, null);







                    /*
			var shottyx1 = [(4*337*bitmapwidthratio),(4*390*bitmapwidthratio)];
			var shottyy1 = [(4*305*bitmapheightratio),(4*305*bitmapheightratio)];
			var shottyx2 = [(4*386*bitmapwidthratio)-shottyx1[0],(4*439*bitmapwidthratio)-shottyx1[1]];
			var shottyy2 = [(4*406*bitmapheightratio)-shottyy1[0],(4*406*bitmapheightratio)-shottyy1[1]];
			
			if(gamestarted==1){
                        




                        ctx.save();

                        ctx.drawImage(img,shottyx1[shotfired],shottyy1[shotfired],shottyx2[shotfired],shottyy2[shotfired],
						(width*.35),width*.35,(height*.70),(width*.30),(height*.35));
						
						
                        canvas.restore();

                    }
                    */



                    shottydst = new Rect((width*.35), (height*.70), (width*.65), (height));
                    if(shotfired==0){
                        shottysrc = new Rect(shottyx1[0], shottyy1[0], shottyx2[0], shottyy2[0]);
                    }else{
                        shottysrc = new Rect(shottyx1[1], shottyy1[1], shottyx2[1], shottyy2[1]);
                    }
                    if(gamestarted==1){
                        shottydst = new Rect((width*.35), (height*.70), (width*.65), (height));




                        canvas.save();

                        
						canvas.drawBitmap(ufo, shottysrc, shottydst, null);
                        canvas.restore();

                    }





                    canvas.save();
                    //cowdst1 = new Rect((widthRatio*((startingpovar)+(roll1*1000-1000))), (heightRatio*((gy1*2000+500))), (widthRatio*((startingpovar)+(roll1*1000-1000))+(396)), (heightRatio*((gy1*2000+500)+(getufoheight))));

                    
                    canvas.drawBitmap(ufo, crosshairsrc, crosshairdst, null);




                    //pavar.setColor(Color.WHITE);
                    //pavar.setStyle(Style.FILL);
                    //canvas.drawPavar(pavar);
                    


                    canvas.restore();

                    //draw gameover
                    if(init==1&&rounds==0&&gamestartedb4==1){
                        //this one is for the gameover
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, gameoversrc, gameoverdst, null);
                        canvas.restore();

                        //high score part
                        woodboarddst = new Rect((width*.55), (height*.40), (width*.90), (height*.50));

                        woodboardsrc = new Rect(woodboardx1[2], woodboardy1[2], woodboardx2[2], woodboardy2[2]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);
                        canvas.restore();

                        //
                        woodboarddst = new Rect((width*.55), (height*.52), (width*.90), (height*.64));

                        woodboardsrc = new Rect(woodboardx1[0], woodboardy1[0], woodboardx2[0], woodboardy2[0]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);

                        pavar.setColor(Color.BLACK);
                        pavar.setTextSize( (1920/32)*2*widthRatio);
                        canvas.drawText(" "+bestscore, (.6*width), (.6*height), pavar);//top left is level

                        canvas.restore();


                        //end

                        //Your score part
                        woodboarddst = new Rect((width*.1), (height*.40), (width*.45), (height*.50));

                        woodboardsrc = new Rect(woodboardx1[0], woodboardy1[0], woodboardx2[0], woodboardy2[0]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);
                        canvas.restore();

                        //
                        woodboarddst = new Rect((width*.1), (height*.52), (width*.45), (height*.64));

                        woodboardsrc = new Rect(woodboardx1[0], woodboardy1[0], woodboardx2[0], woodboardy2[0]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);

                        pavar.setColor(Color.BLACK);
                        pavar.setTextSize( (1920/32)*2*widthRatio);
                        canvas.drawText(" "+score, (.16*width), (.6*height), pavar);//top left is level
                        canvas.drawText("Your Score", (.14*width), (.48*height), pavar);//top left is level
                        canvas.restore();


                        //end

                        //share button
                        woodboarddst = new Rect((width*.55), (height*.66), (width*.90), (height*.78));

                        woodboardsrc = new Rect(woodboardx1[1], woodboardy1[1], woodboardx2[1], woodboardy2[1]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);
                        canvas.restore();

                        //play button
                        woodboarddst = new Rect((width*.1), (height*.66), (width*.45), (height*.78));

                        woodboardsrc = new Rect(woodboardx1[3], woodboardy1[3], woodboardx2[3], woodboardy2[3]);
                        canvas.save();

                        
                        canvas.drawBitmap(ufo, woodboardsrc, woodboarddst, null);
                        canvas.restore();


                    }


                    


                   //
                    //canvas.scale(0.5, 0.5);

                    //canvas.translate(50, 50);


                    surfaceHolder.unlockCanvasAndPost(canvas);
                }catch(Exception e){varerrupedvarernally = true;
                        Log.e("Some Tag", e.getMessage(), e);
                    }
            }
        }
    };

    

   

   
}
