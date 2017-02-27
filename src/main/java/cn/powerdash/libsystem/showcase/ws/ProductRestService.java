/*
 * Project Name: libsystem
 * File Name: RESTSampleService.java
 * Class Name: RESTSampleService
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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.powerdash.libsystem.showcase.domain.Product;
import cn.powerdash.libsystem.showcase.service.ProductService;

/**
 * 
 * 
 * @author SC
 * 
 */
public class ProductRestService {
    protected final Logger log = LoggerFactory.getLogger(ProductRestService.class);

    @Autowired
    ProductService productService;

    @GET
    @Path("/product/{productId}")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response getProducts(@PathParam("productId") String productId) {
        Product result = productService.findProductById(productId);
        if (result == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(result).build();
        }

    }

}
