
  CREATE TABLE "BD1611017"."VENDEDOR" 
   (	"CPF" VARCHAR2(11 BYTE) NOT NULL ENABLE, 
	"NOME" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"ENDERECO" VARCHAR2(30 BYTE), 
	"CIDADE" VARCHAR2(30 BYTE), 
	"CEP" NUMBER(8,0), 
	"UF" VARCHAR2(2 BYTE), 
	"DDD" NUMBER(2,0), 
	"TELEFONE" NUMBER(9,0), 
	"SALARIOBASE" NUMBER NOT NULL ENABLE, 
	"COMISSAO" NUMBER, 
	 CONSTRAINT "VENDEDOR_PK" PRIMARY KEY ("CPF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DADOS_BD2" ;
