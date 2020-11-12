var n = prompt("number of rows in the christmas tree?", "8");

if(n<3){
    alert("Too small! Try giving another input");
}
else if(n<=5){
    christmasTree(n);
    
    // rectangle(tree stem) pattern printing
    for(height=1; height<=2; height++)
    {
        for(tWidth=0; tWidth<(n*2-4)/2; tWidth++)
        {
            document.write(" ")
        }
        for(tWidth=0;tWidth<=2;tWidth++)
        {
            document.write("0");
        }
        document.write("<br>");
    }
}
else{
    christmasTree(n);

    // rectangle(tree stem) pattern printing
    for(height=1; height<=3; height++)
    {
        for(tWidth=0; tWidth<=(n*2-5)/2; tWidth++)
        {
            document.write(" ")
        }
        for(tWidth=0;tWidth<=2;tWidth++)
        {
        document.write("0");
        }
        document.write("<br>");
    } 
}

//triangle pattern printing
function christmasTree(n) {
    for(i=1; i<=n; i++)
    { 
        for(j=i; j<n; j++)
        {
            document.write(" ");
        }
        for(j=1; j<=(i+i-1); j++)
        {
            if(i==1){
                document.write("*");
            }
            else{
            document.write("0");
            }
        }
    
        document.write("<br>");
    }
}
