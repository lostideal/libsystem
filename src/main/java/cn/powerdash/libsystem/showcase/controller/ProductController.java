/*
 * Project Name: libsystem
 * File Name: ProductController.java
 * Class Name: ProductController
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
package cn.powerdash.libsystem.showcase.controller;

import javax.validation.groups.Default;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.powerdash.libsystem.common.constant.ApplicationConstant;
import cn.powerdash.libsystem.common.controller.AbstractController;
import cn.powerdash.libsystem.common.converter.ConverterService;
import cn.powerdash.libsystem.common.dto.ResultDto;
import cn.powerdash.libsystem.common.dto.ResultDtoFactory;
import cn.powerdash.libsystem.common.dto.annotation.OnValid;
import cn.powerdash.libsystem.common.dto.widget.DataTablesResponseDto;
import cn.powerdash.libsystem.common.enums.EErrorCode;
import cn.powerdash.libsystem.common.exception.BizServiceException;
import cn.powerdash.libsystem.common.util.EnumHelper;
import cn.powerdash.libsystem.common.util.web.WebUtil;
import cn.powerdash.libsystem.showcase.domain.Product;
import cn.powerdash.libsystem.showcase.dto.ProductDto;
import cn.powerdash.libsystem.showcase.dto.ProductDto.CreateProduct;
import cn.powerdash.libsystem.showcase.dto.upstream.ProductSearchDto;
import cn.powerdash.libsystem.showcase.enums.EProductCagetory;
import cn.powerdash.libsystem.showcase.service.ProductService;

/**
 * 
 * 
 * @author SC
 * 
 */
@Controller
public class ProductController extends AbstractController {

    @Autowired
    private transient ProductService productService;

    /**
     * Description: render home page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_list";
    }

    /**
     * Description: search product list on the home page
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<DataTablesResponseDto<Product>> search(@RequestBody ProductSearchDto request) {
        DataTablesResponseDto<Product> resp = productService.searchProduct(request);
        resp.setEcho(request.getEcho());
        return ResultDtoFactory.toAck(StringUtils.EMPTY, resp);
    }

    /**
     * Description: render add-product page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_add";
    }

    /**
     * Description: add a product
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    @ResponseBody
    public ResultDto<String> add(@RequestBody @OnValid(value = { CreateProduct.class, Default.class }) ProductDto dto) {
        Product entity = ConverterService.convert(dto, Product.class);
        productService.saveProduct(entity);
        return ResultDtoFactory.toRedirect(WebUtil.getFullUrlBasedOn(ApplicationConstant.GLOBAL_CONTEXT + "/products"));
    }

    /**
     * Description: render the detail page of a product
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") String id, Model model) {
        Product detail = productService.findProductById(id);
        if (detail == null) {
            throw new BizServiceException(EErrorCode.PRODUCT_NOT_FOUND);
        }
        model.addAttribute("detail", detail);
        model.addAttribute("categoryList", EnumHelper.inspectConstants(EProductCagetory.class));
        return "product/product_edit";
    }

    /**
     * Description: update a product
     *
     * @param id
     * @param dto
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultDto<String> update(@PathVariable(value = "id") String id, @RequestBody @OnValid ProductDto dto) {
        Product entity = ConverterService.convert(dto, Product.class);
        entity.setId(id);
        productService.saveProduct(entity);
        return ResultDtoFactory.toAck("successfully updated!");
    }

    /**
     * Description: delete a product
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultDto<String> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResultDtoFactory.toAck("successfully deleted!");
    }

}
