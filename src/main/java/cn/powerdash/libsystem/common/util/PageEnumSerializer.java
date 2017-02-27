/*
 * Project Name: libsystem
 * File Name: PageEnumSerializer.java
 * Class Name: PageEnumSerializer
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

package cn.powerdash.libsystem.common.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import cn.powerdash.libsystem.common.enums.PageEnum;

/**
 * 
 * 
 * @author SC
 * 
 */

public class PageEnumSerializer extends JsonSerializer<PageEnum> {

    @Override
    public void serialize(PageEnum value, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeString(value.getCode());
        generator.writeFieldName("text");
        generator.writeString(value.getText());
        generator.writeFieldName("name");
        generator.writeString(value.name());
        generator.writeEndObject();
    }

    @Override
    public Class<PageEnum> handledType() {
        return PageEnum.class;
    }
}
