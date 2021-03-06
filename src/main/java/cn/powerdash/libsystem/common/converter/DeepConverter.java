/*
 * Project Name: libsystem
 * File Name: DeepConverter.java
 * Class Name: DeepConverter
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * 
 *
 * http://www.hengtiansoft.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.powerdash.libsystem.common.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import net.sf.cglib.core.Converter;

import org.apache.commons.lang.time.DateUtils;

/**
 * customized {@link Converter}
 * 
 * @author SC
 * 
 */
public class DeepConverter implements Converter {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Object convert(Object value, Class targetClass, Object context) {
        if (targetClass != null && value != null) {
            Class<? extends Object> sourceClass = value.getClass();
            if (targetClass.equals(sourceClass)) {
                return value;
            }
            // primitive type
            if (sourceClass.isPrimitive() || targetClass.isPrimitive()) {
                return value;
            }
            // collection
            if (Collection.class.isAssignableFrom(sourceClass) && Collection.class.isAssignableFrom(targetClass)) {
                // not supported
                return null;
            } else if (Timestamp.class.isAssignableFrom(sourceClass) && targetClass.isAssignableFrom(String.class)) {
                return new SimpleDateFormat(TIMESTAMP_FORMAT).format((Timestamp) value);
            } else if (Date.class.isAssignableFrom(sourceClass) && targetClass.isAssignableFrom(String.class)) {
                return new SimpleDateFormat(DATE_FORMAT).format((Date) value);
            } else if (java.util.Date.class.isAssignableFrom(targetClass) && sourceClass.isAssignableFrom(String.class)) {
                try {
                    return DateUtils.parseDate(value.toString(), new String[] { "yyyy-MM-dd" });
                } catch (ParseException e) {
                    return null;
                }
            } else if (targetClass.isAssignableFrom(sourceClass)) {
                return value;
            }
            // complex type
            if (targetClass.getClassLoader() != null && sourceClass.getClassLoader() != null) {
                return ConverterService.convert(value, targetClass, null);
            }

        }
        return null;
    }

}
