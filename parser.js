function parser(test)
{
    if(typeof test==null|| test==null)
        return;
    if(typeof test=='object')
    {
        let obj;
        if(Array.isArray(test))
            obj = [];
        else obj ={};
        for(let item in test)
        {
            
            if(test[item]==null)
                continue;
            else if(typeof test[item] =='object')
            {
                //console.log(typeof item, typeof test[item],item,test[item]);
                let t1 = parser(test[item]);
                //console.log(t1);
                if(t1!=undefined)
                {
                    if(Array.isArray(obj))
                        obj.push(t1);
                    else
                        obj[item] = t1;
                }
            }
            else
            {
                
                if(Array.isArray(obj))
                    obj.push(test[item])
                else
                    obj[item] = test[item];
            }
        }
        if(Object.keys(obj).length!=0)
            return obj;
    }
    else
        return test;
}

parser(['Shashank',23,true]);