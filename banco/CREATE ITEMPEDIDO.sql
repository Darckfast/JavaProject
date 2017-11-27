  CREATE TABLE "BD1611017"."ITEMPEDIDO" 
   (	"NUMEROPEDIDO" NUMBER, 
	"CODIGOPRODUTO" NUMBER, 
	"QTDEVENDA" NUMBER, 
	 CONSTRAINT "PK_ITEMPEDIDO" PRIMARY KEY ("NUMEROPEDIDO", "CODIGOPRODUTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2"  ENABLE, 
	 CONSTRAINT "FK_PEDIDO" FOREIGN KEY ("NUMEROPEDIDO")
	  REFERENCES "BD1611017"."PEDIDO" ("NUMERO") ENABLE, 
	 CONSTRAINT "FK_PRODUTO" FOREIGN KEY ("CODIGOPRODUTO")
	  REFERENCES "BD1611017"."PRODUTO" ("CODIGO") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2" ;