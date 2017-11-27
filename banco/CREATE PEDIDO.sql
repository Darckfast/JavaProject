
  CREATE TABLE "BD1611017"."PEDIDO" 
   (	"NUMERO" NUMBER NOT NULL ENABLE, 
	"DATAEMISSAOPEDIDO" DATE NOT NULL ENABLE, 
	"DATAPAGTO" DATE, 
	"STATUS" NUMBER(1,0), 
	"CPFCLIENTE" VARCHAR2(11 BYTE), 
	"CPFVENDEDOR" VARCHAR2(11 BYTE), 
	 CONSTRAINT "PEDIDO_PK" PRIMARY KEY ("NUMERO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2"  ENABLE, 
	 CONSTRAINT "FK_CLIENTE" FOREIGN KEY ("CPFCLIENTE")
	  REFERENCES "BD1611017"."CLIENTE" ("CPF") ENABLE, 
	 CONSTRAINT "FK_VENDEDOR" FOREIGN KEY ("CPFVENDEDOR")
	  REFERENCES "BD1611017"."VENDEDOR" ("CPF") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2" ;