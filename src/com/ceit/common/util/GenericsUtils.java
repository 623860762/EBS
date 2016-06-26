package com.ceit.common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

/**
 * 公共方法，包括json转换、常规类型间的转换、有关时间的转换等等
 * @author wujinshui
 *
 */

@SuppressWarnings({"unused","unchecked"})
public class GenericsUtils {
	/**
	 * 
	 * @param object
	 * @return JSON format string
	 */
	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}

	/**
	 * 
	 * @param json
	 *            JSON format string
	 * @param typeOfT
	 *            result object type
	 * @return result object of given type
	 */
	public static Type fromJson(String json, Type typeOfT) {
		return new Gson().fromJson(json, typeOfT);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return new Gson().fromJson(json, classOfT);
	}

	public static Class getGenericSuperclassType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	/**
	 * 把一个List中的obj反射到一个List的HashMap中
	 * 
	 * @param obj
	 * @return
	 */
	public static List mappingObjectToForm(List list) {
		try {
			if (list != null && list.size() > 0) {
				List resultList = new ArrayList();
				Class c = list.get(0).getClass();
				Method m[] = c.getDeclaredMethods();

				for (int listSize = 0; listSize < list.size(); listSize++) {
					Map<String, String> hashMap = null;
					hashMap = getFieldVlaue(list.get(listSize));
					// for (int i = 0; i < m.length; i++) {
					// if (m[i].getName().indexOf("get") == 0) {
					// Object val= m[i].invoke(list.get(listSize), new
					// Object[0]);
					// hashMap.put(m[i].getName().toString(),val==null?"":val.toString());
					// }
					// }
					resultList.add(hashMap);
				}
				return resultList;
			} else {
				return new ArrayList(0);
			}
		} catch (Throwable e) {
					}
		return null;
	}

	public static Map<String, String> getFieldVlaue(Object obj)
			throws Exception {
		Map<String, String> mapValue = new HashMap<String, String>();
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			String name = field.getName();

			String strGet = "get" + name.substring(0, 1).toUpperCase()
					+ name.substring(1, name.length());
			Method methodGet = cls.getDeclaredMethod(strGet);
			Object object = methodGet.invoke(obj);

			if (field.getType().getClassLoader() != null) {
				// 自己定义的类
				if (object != null) {
					// 如果对象有值
					getFieldValueSubClass(mapValue, name, object);
				}
			} else {

				String value = object != null ? object.toString() : "";
				mapValue.put(name, value);
			}
		}
		return mapValue;
	}

	/**
	 * 暂时只支持2层
	 */
	private static void getFieldValueSubClass(Map<String, String> mapValue,
			String paramentName, Object object) throws Exception {
		Class<?> cls = object.getClass();
		Field[] fields = cls.getDeclaredFields();

		for (Field field : fields) {
			if (field.getType().getClassLoader() == null) {// 只处理第二级不是自定义类的情况
				String name = field.getName();
				String strGet = "get" + name.substring(0, 1).toUpperCase()
						+ name.substring(1, name.length());
				Method methodGet = cls.getDeclaredMethod(strGet);
				Object o = methodGet.invoke(object);
				String value = o != null ? o.toString() : "";
				mapValue.put(paramentName + "." + name, value);
			}

		}
	}

	/**
	 * 获取当前系统时间,格式自定义
	 */
	public static Long getCurrentDate(String partten) {
		Long dateLong = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(partten);
		try {
			String dateStr = sdf.format(date);
			dateLong = new Long(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateLong;
	}

	/**
	 * 获取当前系统时间,格式为【yyyyMMdd】
	 */
	public static Long getCurrentDate() {
		Long dateLong = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			String dateStr = sdf.format(date);
			dateLong = new Long(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateLong;
	}

	/**
	 * 根据时间，返回unix时间戳 传入时间的时间格式是:yyyy-MM-dd HH:mm:ss 返回
	 * 
	 * @return
	 */
	public static Long getUnixTimes(String datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(datetime);
			return date.getTime() / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间，返回unix时间戳 传入时间的时间格式是:自定义【yyyyMMdd或其他】 返回
	 * 
	 * @return
	 */
	public static Long getUnixTimes(String datetime, String parseStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(parseStr);
		try {
			Date date = sdf.parse(datetime);
			return date.getTime() / 1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据时间戳，返回时间,返回格式yyyy-mm-dd HH:mm:ss
	 * 
	 * @param second
	 *            单位秒
	 * @return
	 */
	public static String getTimesFromUnix(Long second) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(second * 1000L);
		return date;
	}
	/**
	 * 根据时间戳，返回时间,返回格式
	 * 
	 * @param second
	 *            单位秒
	 * @return
	 */
	public static String getTimesFromUnix(Long second,String patten) {
		if(StringUtils.isEmpty(patten)){
			patten = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		String date = sdf.format(second * 1000L);
		return date;
	}
	/**
	 * 将字符串转成int,如字符串存在不能转换的字符,则会抛出NumberFormatException. 若字符串为null,""," ",则返回0
	 * 
	 * @param param
	 *            欲转成int的字符串
	 * @return int
	 */
	public static int StringToInt(String param) {
		int result = 0;

		if (StringUtils.isNotBlank(param)) {
			result = Integer.parseInt(param);
		}

		return result;
	}

	/**
	 * 将字符串转成int,如字符串存在不能转换的字符,则会抛出NumberFormatException.
	 * 若字符串为null,""," ",则返回defaultVal
	 * 
	 * @param param
	 *            欲转成int的字符串
	 * @param defaultVal
	 *            默认值
	 * @return int
	 */
	public static int StringToInt(String param, int defaultVal) {
		int result = defaultVal;

		if (StringUtils.isNotBlank(param)) {
			result = Integer.parseInt(param);
		}

		return result;
	}

	/**
	 * 将分页查询的总数和列表转成JSONObject
	 * 
	 * @param total
	 * @param list
	 * @return
	 */
	public static Map<String, Object> orgJsonFromQueryResult(long total,
			List<?> list) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", list);
		return jsonMap;
	}

	/**
	 * 使用UTF-8将指定字符串解码
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeToUTF8(String param)
			throws UnsupportedEncodingException {
		if (param == null) {
			throw new NullPointerException("param is Null!");
		}

		return URLDecoder.decode(param, "UTF-8");
	}

	public static String ifValue(String srcStr, String checkVal,
			String replaceValue) {

		if (srcStr == checkVal || (srcStr != null && srcStr.equals(checkVal))
				|| (checkVal != null && checkVal.equals(srcStr))) {
			return replaceValue;
		}
		return srcStr;
	}

	public static String emptyIfNull(String srcStr) {

		return ifValue(srcStr, null, "");
	}

	/**
	 * 解析URL，把URL的参数解析到map中
	 * 
	 * @param confInfo
	 * @return
	 */
	public static HashMap getConfigReslv(String confInfo) {
		HashMap map = new HashMap();
		String info[] = confInfo.split("&");

		for (int i = 0; i < info.length; i++) {
			String tem[] = info[i].split("=");
			map.put(tem[0], tem[1]);
		}

		return map;
	}

	/**
	 * 如果为空则返回默认值
	 * 
	 * @param str
	 * @param defaultStr
	 * @return
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return StringUtils.isBlank(str) ? defaultStr : str;
	}

	/**
	 * 如果为空返回默认值.
	 * 
	 * @author gezq
	 */
	public static int defaultIfBlank(String str, int defaultInt) {
		return StringUtils.isBlank(str) ? defaultInt : Integer.parseInt(str);
	}

	/**
	 * 如果为空返回默认值.
	 * 
	 * @author gezq
	 */
	public static double defaultIfBlank(String str, double defaultDouble) {
		return StringUtils.isBlank(str) ? defaultDouble : Double.parseDouble(str);
	}
	
	/**
	 * 如果为空返回默认值.
	 * 
	 * @author gezq
	 */
	public static long defaultIfBlank(String str, long defaultDouble) {
		return StringUtils.isBlank(str) ? defaultDouble : Long.parseLong(str);
	}

	public static void main(String args[]) {
	}
}
