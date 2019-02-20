package info.kowalczuk.spring.impl.utils;

import com.thoughtworks.xstream.XStream;

import java.util.Collection;


public class XmlUtils {

    public static <T> String toXML(T object) {
        XStream xstream = new XStream();
        //xstream.allowTypeHierarchy(Collection.class);
        //xstream.allowTypesByWildcard(new String[] { "info.kowalczuk.spring.**" });
        xstream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xstream.toXML(object);
    }

    public static <T> T fromXML(String xml, Class<T> _class) {
        XStream xstream = new XStream();
        xstream.allowTypeHierarchy(Collection.class);
        xstream.allowTypesByWildcard(new String[] { "info.kowalczuk.spring.**" });
        xstream.alias(_class.getSimpleName().toLowerCase(), _class);
        return (T) xstream.fromXML(xml);
    }
}
