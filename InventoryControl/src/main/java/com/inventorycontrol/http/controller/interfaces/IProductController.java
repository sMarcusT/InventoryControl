package com.inventorycontrol.http.controller.interfaces;

import com.inventorycontrol.http.dto.message.MessageError;
import com.inventorycontrol.http.dto.request.ProductRequest;
import com.inventorycontrol.http.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Produtos")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product")
@Validated
public interface IProductController {

    @Operation(summary = "Salva um novo produto.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Caso o produto seja armazenado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "productName": "Cebolitos",
                                              "weight": "Peso",
                                              "controlled": true,
                                              "minimumQuantity": 2,
                                              "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Caso o usu??rio n??o tenha a permiss??o necess??ria para realizar a opera????o.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "timestamp": "23-05-2022 17:38:25",
                                                "status": 403,
                                                "type": "http://localhost:8080/api/inventorycontrol/product",
                                                "title": "N??o autorizado.",
                                                "detail": "Usu??rio n??o tem permiss??o para acessar esse recurso!"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Caso o produto j?? esteja armazenado no sistema.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "timestamp": "23-05-2022 12:41:33",
                                                 "status": 400,
                                                 "type": "http://localhost:8080/api/inventorycontrol/product",
                                                 "title": "Dado ??nico j?? cadastrado.",
                                                 "detail": "Produto j?? est?? armazenado no sistema."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Caso o usu??rio n??o esteja autenticado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "path": "http://localhost:8080/api/inventorycontrol/product",
                                                 "message": "The Token has expired on Mon May 23 17:39:42 BRT 2022.",
                                                 "error": "Unauthorized",
                                                 "status": 401
                                            }
                                            """
                            )
                    )
            )
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = """
                    Dados para salvar um novo produto.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "productName": "Cebolitos",
                                      "weight": "Peso",
                                      "controlled": true,
                                      "minimumQuantity": 2,
                                      "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                    }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductRequest productRequest);

    @Operation(summary = "Atualiza o produto por ID.", description = """
            Atualiza o produto passando o ID na URL.
            """)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso o produto seja alterado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "cityId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b",
                                              "productName": "Cebolitos",
                                              "weight": "Peso",
                                              "controlled": true,
                                              "minimumQuantity": 2,
                                              "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL n??o seja de nenhum produto.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "timestamp": "23-05-2022 11:56:30",
                                                 "status": 404,
                                                 "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "title": "Recurso n??o encontrado.",
                                                 "detail": "Produto n??o est?? armazenado no sistema."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Caso o produto j?? esteja armazenado no sistema.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "timestamp": "23-05-2022 12:42:53",
                                                 "status": 400,
                                                 "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "title": "Dado ??nico j?? cadastrado.",
                                                 "detail": "J?? existe um produto armazenado com esse c??digo."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Caso o usu??rio n??o tenha a permiss??o necess??ria para realizar a opera????o.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "timestamp": "23-05-2022 17:38:25",
                                                "status": 403,
                                                "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                "title": "N??o autorizado.",
                                                "detail": "Usu??rio n??o tem permiss??o para acessar esse recurso!"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Caso o usu??rio n??o esteja autenticado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "path": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "message": "The Token has expired on Mon May 23 17:39:42 BRT 2022.",
                                                 "error": "Unauthorized",
                                                 "status": 401
                                            }
                                            """
                            )
                    )
            )
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = """
                    Dados para atualizar um produto.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "productName": "Cebolitos",
                                      "weight": "Peso",
                                      "controlled": true,
                                      "minimumQuantity": 2,
                                      "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                    }
                                    """
                    )
            )
    )
    @PutMapping("/{productId}")
    ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductRequest productRequest, @PathVariable String productId);


    @Operation(summary = "Consulta todas os produtos.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "productName": "Cebolitos",
                                              "weight": "Peso",
                                              "controlled": true,
                                              "minimumQuantity": 2,
                                              "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Caso o usu??rio n??o tenha a permiss??o necess??ria para realizar a opera????o.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "timestamp": "23-05-2022 17:38:25",
                                                "status": 403,
                                                "type": "http://localhost:8080/api/inventorycontrol/product/all",
                                                "title": "N??o autorizado.",
                                                "detail": "Usu??rio n??o tem permiss??o para acessar esse recurso!"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Caso o usu??rio n??o esteja autenticado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "path": "http://localhost:8080/api/inventorycontrol/product/all",
                                                 "message": "The Token has expired on Mon May 23 17:39:42 BRT 2022.",
                                                 "error": "Unauthorized",
                                                 "status": 401
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/all")
    ResponseEntity<List<ProductResponse>> findAll();


    @Operation(summary = "Consulta o produto por ID.", description = """
            Consulta o produto passando o ID na URL.
            """)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso a consulta seja efetuada com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "productName": "Cebolitos",
                                              "weight": "Peso",
                                              "controlled": true,
                                              "minimumQuantity": 2,
                                              "categoryId": "3047caa5-621e-4c42-89ee-e6b7c2f1b16b"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL n??o seja de nenhum produto.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "timestamp": "",
                                                 "status": 404,
                                                 "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "title": "Recurso n??o encontrado.",
                                                 "detail": "Produto n??o est?? salvo no sistema."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Caso o usu??rio n??o tenha a permiss??o necess??ria para realizar a opera????o.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "timestamp": "23-05-2022 17:38:25",
                                                "status": 403,
                                                "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                "title": "N??o autorizado.",
                                                "detail": "Usu??rio n??o tem permiss??o para acessar esse recurso!"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Caso o usu??rio n??o esteja autenticado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "path": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "message": "The Token has expired on Mon May 23 17:39:42 BRT 2022.",
                                                 "error": "Unauthorized",
                                                 "status": 401
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/{productId}")
    ResponseEntity<ProductResponse> findById(@PathVariable String productId);


    @Operation(summary = "Deleta um produto por ID.", description = """
            Deleta o produto passando o ID na URL.

            """)
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Caso o produto seja deletado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "message": "Produto deletado com sucesso."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Caso o ID enviado na URL n??o seja de nenhum produto.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "timestamp": "23-05-2022 11:56:30",
                                                 "status": 404,
                                                 "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "title": "Recurso n??o encontrado.",
                                                 "detail": "Produto n??o armazenado no sistema."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Caso o usu??rio n??o tenha a permiss??o necess??ria para realizar a opera????o.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "timestamp": "23-05-2022 17:38:25",
                                                "status": 403,
                                                "type": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                "title": "N??o autorizado.",
                                                "detail": "Usu??rio n??o tem permiss??o para acessar esse recurso!"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Caso o usu??rio n??o esteja autenticado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                 "path": "http://localhost:8080/api/inventorycontrol/product/{productId}",
                                                 "message": "The Token has expired on Mon May 23 17:39:42 BRT 2022.",
                                                 "error": "Unauthorized",
                                                 "status": 401
                                            }
                                            """
                            )
                    )
            )
    })
    @DeleteMapping(path = "/{productId}")
    ResponseEntity<MessageError> delete(@PathVariable String productid);
}
