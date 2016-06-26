package com.ceit.common.cache.ebp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceit.common.cache.EhcacheManager;
import com.ceit.common.entity.EBPDict;
import com.ceit.common.services.IEBPDictService;
import com.ceit.servlet.CacheServiceInitServlet;

public class EBPDictCache {
	static Log log=LogFactory.getLog(EBPDictCache.class);
    static Cache cache=EhcacheManager.cacheManager.getCache("EBP_DICT");
   
    public static EBPDict get(String dicId){
         Element e=cache.get(dicId);
         if(e==null){
              return null;
         }
         return (EBPDict)e.getObjectValue();
    }
   
    @SuppressWarnings("unchecked")
    public static List<EBPDict> getByIdOrCode(String key) { 
         Element el=cache.get("LIST_"+key);
       TreeSet<EBPDict> set=(TreeSet<EBPDict>) el.getObjectValue();
       java.util.Iterator<EBPDict> it=set.iterator();
       List<EBPDict> list=new ArrayList<EBPDict>();
       while(it.hasNext())
       {
            EBPDict dict = it.next();
            list.add(dict);
       }
         return list;
    }
   
    public static void set(EBPDict dict) {
         log.info("正在数据字典配置信息:"+dict.getDicName());
         Element element = new Element(dict.getDicId(),dict);
         cache.put(element);
    }
   
    public static void removeById(String dict)
    {
         log.info("移除ID为"+dict+"的数据字典配置信息");
         EBPDict res= get(dict);
         String resId=res.getDicId();
         cache.remove(resId);
    }
   
    @SuppressWarnings("unchecked")
    public static void init(){
    	System.out.println("=========================");
        System.out.println("正在初始化数据字典配置信息");
        System.out.println("=========================");
        log.info("正在初始化数据字典配置信息");
        if(cache!=null && cache.getSize()!=0){
             log.warn("数据字典配置数据不为空，首先进行清理");
             cache.removeAll();
        }
        try {
        	IEBPDictService service=(IEBPDictService)CacheServiceInitServlet.springContext.getBean("ebpDictService");
	         List<EBPDict> list=service.getAll();
	         for(int i=0;i<list.size();i++){
	              EBPDict mc=list.get(i);
	              String pid=mc.getDicParentId();
	              Element e1=cache.get("LIST_"+pid);
	              if(e1==null){
	                   e1=new Element("LIST_"+pid,new TreeSet<EBPDict>());
	                  cache.put(e1);
	              }
	              Set<EBPDict> set=(Set<EBPDict>)e1.getObjectValue();
	              set.add(mc);
	
	           Element e2=new  Element(mc.getDicId().toUpperCase(),mc);
	              cache.put(e2);
	         }
	         System.out.println("=========================");
	         System.out.println("初始化完毕，共初始化:"+list.size()+"条数据");
	         System.out.println("=========================");
	         log.info("初始化完毕，共初始化:"+list.size()+"条数据");
         } catch (Exception e) {
        	System.out.println("======================================ERROR");
			e.printStackTrace();
		 } 
         
    }
}
