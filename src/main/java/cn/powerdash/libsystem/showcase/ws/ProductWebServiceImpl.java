/*
 * Project Name: libsystem
 * File Name: CategoryServiceImpl.java
 * Class Name: CategoryServiceImpl
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

package cn.powerdash.libsystem.showcase.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import cn.powerdash.libsystem.showcase.domain.Product;
import cn.powerdash.libsystem.showcase.service.ProductService;

/**
 * Sample implementation
 * 
 * @author SC
 * 
 */

@WebService(endpointInterface = "cn.powerdash.libsystem.showcase.ws.ProductWebService")
public class ProductWebServiceImpl implements ProductWebService {

    @Autowired
    ProductService productService;

    public Product getProductById(String productId) {
        return productService.findProductById(productId);
    }

}
