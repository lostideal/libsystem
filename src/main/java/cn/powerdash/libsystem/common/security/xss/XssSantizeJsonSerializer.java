/*
 * Project Name: libsystem
 * File Name: XssSantizeJsonSerializer.java
 * Class Name: XssSantizeJsonSerializer
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * Licensed under the Hengtiansoft
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

package cn.powerdash.libsystem.common.security.xss;

import java.io.IOException;

import org.owasp.encoder.Encode;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Sanitize String type fields in object for json serialization.
 * 
 * @author SC
 *
 */
public class XssSantizeJsonSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (value != null) {
            String encoded = Encode.forHtml(value);
            jgen.writeString(encoded);
        }

    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }

}
