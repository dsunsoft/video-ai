package com.dsunsoft.common.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author ygm 自定义把map转换成指定的格式 <key1>value1</key1> <key2>value2</key2>
 */
public class MapCustomConverter extends AbstractCollectionConverter {

	public MapCustomConverter(Mapper mapper) {
		super(mapper);
	}

	@Override
	public boolean canConvert(Class type) {
		return type.equals(HashMap.class) || type.equals(Hashtable.class)
				|| type.getName().equals("java.util.LinkedHashMap") || type.getName().equals("sun.font.AttributeMap");
		// Used by java.awt.Font in JDK 6
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Map map = (Map) source;
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);

			// writer.addAttribute("key", entry.getKey().toString());
			// writer.addAttribute("value", entry.getValue().toString());
			writer.setValue(entry.getValue().toString());
			writer.endNode();
		}
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Map map = (Map) createCollection(context.getRequiredType());
		populateMap(reader, context, map);
		return map;
	}

	protected void populateMap(HierarchicalStreamReader reader, UnmarshallingContext context, Map map) {
		while (reader.hasMoreChildren()) {
			reader.moveDown();
			Object key = reader.getNodeName();// reader.getAttribute("key");
			Object value = reader.getValue(); // reader.getAttribute("value");
			map.put(key, value);
			reader.moveUp();
		}
	}
}