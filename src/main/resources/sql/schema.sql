DROP DATABASE IF EXISTS `iems`;
CREATE DATABASE  IF NOT EXISTS `iems` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `iems`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: iems
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
                          `brand_id` varchar(35) NOT NULL,
                          `filial_owner` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES ('blon',NULL),('Tripowin','Linsoul');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
                           `client_id` varchar(255) NOT NULL,
                           `age` int NOT NULL,
                           `country` varchar(255) DEFAULT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `user_id` varchar(255) NOT NULL,
                           PRIMARY KEY (`client_id`),
                           UNIQUE KEY `UK_smrp6gi0tckq1w5rnd7boyowu` (`user_id`),
                           CONSTRAINT `FKtiuqdledq2lybrds2k3rfqrv4` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('026166ab-0e0e-4b44-a3a8-9a8be3515ee3',64,'SE','Rayna Holborn','3dadf522-eb90-4c63-8b5a-eedaeefdf8f7')
                           ,('0bfcb730-8d49-403f-a6be-e5a84fb5038f',3,'PE','Fergus Dobell','b424ea73-e199-488b-8e26-396be8117948')
                           ,('0e1d3e07-6bec-4e04-b79e-bcd5b8c19d64',29,'MX','Eduard Smallwood','2594f87b-9656-4ed7-b1f7-2ff2e30ac241')
                           ,('0e33755c-a201-4d09-9cae-51b681a6cea5',50,'ID','Tyler Fessby','030be46e-d65c-4a6d-acbe-4fc74a500fcb')
                           ,('0e9072fa-90f1-4f3c-b761-e5e45e2d28a2',5,'CN','Joyann Larter','112966d7-f26a-4291-ae4c-43914d9bd814')
                           ,('0eccfaa7-bc65-4d09-9895-757070c7c982',64,'FR','Alvina McKellar','5e1753d6-5087-4b60-b018-5b8e25eac90d')
                           ,('1168157d-b83e-4759-9874-4ffe4fcb114c',12,'CN','Sol Mulbery','634c14f4-e9cf-4ae7-b290-16333aae74a3')
                           ,('12c7a7ae-7a62-4e95-b4f5-c90fcd6dd198',11,'UA','Raychel Rudwell','53c075b6-d4e7-46da-bdaa-780a7e4cd1d9')
                           ,('13b0f363-fc69-4e93-b15a-39e6db6d483e',74,'AR','Hall Balmer','8a4af63c-42af-4866-978c-664ed7a6b87d')
                           ,('185784e0-de3d-4d19-b58e-f26a831352ad',75,'ID','Baron Stabbins','8d067791-2fb2-445e-b98e-e5905fc77184')
                           ,('1d0b7b0c-be11-4772-89f1-7f25eb8780f4',10,'CN','Fulton Farenden','70be5165-61d8-4429-b7c4-b98bfb6af286')
                           ,('2174d470-faf0-404c-93ef-d683accfe22e',39,'PS','Amie Cornell','7e481393-35c0-49b9-83a0-3f6c4984a5bd')
                           ,('2458c063-0b97-4705-8911-ae354b4463d3',24,'SE','Rosalia Freeman','12a2a4c7-0d3d-4fed-81c0-42f4606cc25f')
                           ,('28f47bfc-045b-4b7a-9a29-a8ccd171de75',17,'CN','Wynn Forrestor','9125a813-2da7-400c-a1ff-9e6d32285d9a')
                           ,('297c00d7-e968-4d44-b9db-c4a310341f21',74,'CN','Thedric Anthes','9c401a74-1742-40d2-ac01-c6b7cf10b0bc')
                           ,('29e9552b-c12f-409d-94be-1fd242f0296a',3,'CN','Stephine Kiddle','4b6af832-7881-4a12-94fe-d83ad9bc422f')
                           ,('2d411bf0-fcfd-4337-8a04-d45d4ee37aa7',51,'FR','Tally Alfonsini','8ca240e6-2b81-4f75-8281-cc9a82ce393e')
                           ,('2e9b7bb4-3511-45cf-89d9-98edfed7f4aa',48,'AF','Jannel McKern','43fb8788-5916-4c82-bbf3-ea3452e3cd1c')
                           ,('2ec017f4-6a7d-4def-8404-126ba3215f33',33,'SD','Curtice Esson','3d257a86-3318-4bfe-b8f0-d3932f89aaa7')
                           ,('2f226e8d-bd90-4611-a825-72d78599859f',13,'EG','Gayleen Yurchenko','615998b8-fef5-421f-b4f6-2b956810c480')
                           ,('2fac6eff-d709-4f02-bccc-3a4860b3fa40',51,'CN','Fara Ege','079e063b-86a5-412b-bec9-ba0e08fd825a')
                           ,('3162c960-8820-4cac-bbcb-9a55e6c717ea',51,'CN','Nero Beecroft','3831a1c6-3b06-4498-b2d3-9fbd559029d7')
                           ,('37e4f74f-4793-4a1c-ae1d-4807142d803a',26,'ID','Pansy Kleinpeltz','86fcdff1-3a28-4e61-81fd-7bb5cfe2588c')
                           ,('3f24bde6-8391-402f-9756-b11313305282',34,'CN','Erasmus Bredes','69dc991f-8aad-41c3-a8b3-b41990b3fda3')
                           ,('40a091ac-276f-4382-8449-1a430497d546',7,'LK','Fabien Adams','773728d4-b28e-4879-a25a-9cb6bc513a8b')
                           ,('42727350-37ad-458c-9fe8-6d598b230320',72,'KZ','Matilde Raycroft','025a47b6-15da-463d-89dc-7ceef1fb19de')
                           ,('4c0b3fe4-c078-4794-a92e-3ef0b06e91c1',6,'PE','Alethea Battabee','7836feb5-2427-45fa-b3e0-42ab2570ca55')
                           ,('4c24f53b-f1dc-48ea-a847-3091a9c6fee5',25,'BW','Amity McTavish','821c8d66-c90f-4118-a947-af0a785e7c65')
                           ,('4ef5756c-1eda-4b1d-9d98-a513effcf48e',30,'BR','Davey Thursfield','a9879a15-3867-43cb-a894-54c3f1a976f1')
                           ,('502134c9-ac9c-4120-a177-d5e67a6a4c34',11,'PL','Brewer Sicily','0f1cb64b-3b4e-4cb6-9f60-9addcc9108d8')
                           ,('50628b0b-9f38-48bd-a0f0-f6d28c6182ac',44,'IT','Sterne Hastler','11bf3d46-555a-45ed-9ec0-c229dcfdac30')
                           ,('5273cc37-dd12-4687-b153-4237c08700d1',55,'JP','Annaliese Southers','4d3ca786-e8e2-4b55-88a5-a36a0810aadf')
                           ,('52826aa2-42f0-4f31-aa98-fd2c2a00cd35',10,'RU','Far Toten','4a89894e-d214-401e-8eb1-74a379be8bd0')
                           ,('537f26e4-09b7-4b27-a37a-6318b19f6905',14,'PE','Alan Josey','92f000c3-bd79-47a6-b833-6e381a3e4140')
                           ,('53d95bc0-2979-40f3-aa0c-92a86ee0f7f5',31,'CN','Selene Paffot','70d801c1-844a-4725-88e4-fb144aca1a61')
                           ,('53f2d680-4a5f-446b-809e-ba5a6fa9cbf9',9,'PE','Melissa Duckham','b0b689eb-1cb1-4166-b63c-95c3a8fbb7fe')
                           ,('5425951a-cc1d-4ef3-be85-a4b6cf04b72c',42,'CN','Aguie Harriskine','8f3f9d67-9b27-4ea6-8d87-2413b68972be')
                           ,('5a5bb0ab-b95a-4896-9fe4-18b03e69da52',14,'CO','Delmore Craxford','23553a25-9c34-420b-8c21-975ccd172b02')
                           ,('5f6bf55c-722e-432a-bd64-f2f3fbe545de',60,'CN','Modestine Gounot','a2a5e8f7-1304-458f-996d-bb3f90a6425a')
                           ,('62f27018-93c4-491d-9bfb-0a0787135493',37,'ID','Jo Wyrill','0ee16375-7e90-4361-9a49-2cd4e5d7ba36')
                           ,('66dd4d4a-a8f9-4701-8a6b-52230e6dec9e',51,'JP','Byron Colmer','781bcc56-d1c1-4e92-b5f7-5f4bc2b59e33')
                           ,('6b3842b5-cd8b-416b-8c9f-4ccb94b886b7',72,'RU','Claire Corrin','a5c5655b-fc66-41f5-a1ce-d39a4f5c26bd')
                           ,('6ccfb855-b6b7-42f6-b9b5-acd0cda2af31',66,'WS','Corrina Brocks','1986275d-4cd4-4ea4-bb20-6652b97c4581')
                           ,('70dd2bd8-49a1-4065-90ba-8e37f392c3a9',38,'JP','Erminia Shenton','0f180f7d-e1a7-465d-97da-77039201a57a')
                           ,('746f8395-f72b-4755-a739-e82b7d040172',65,'CN','Phyllida Fairburne','7ea110c0-a8a9-4e5c-b988-68937a2e73f4')
                           ,('74846a6f-60df-4428-a8f4-6c264e5a73c2',18,'MM','Gwyneth Jachimiak','40d46332-a717-4f45-80bb-1cfdc23da856')
                           ,('749b68c9-4172-40f4-aaee-3ac80b8ca838',32,'UA','Katusha Brunt','41ba56dc-80cc-4010-8032-8ed5b4ff5854')
                           ,('74e95245-f20d-11ee-848a-b04f13cfd672',15,'BOG/COL','Deyby','6589acc5-f20d-11ee-848a-b04f13cfd672')
                           ,('76fca95d-8da0-4048-80e0-258edfece05f',22,'CN','Drona Ible','15f36dc7-983f-4331-8258-fe22948fe059')
                           ,('782bf7a7-8d45-4090-b8f6-9094a97956d0',1,'CN','Henrieta de Leon','1307ed85-fc5c-4a87-9460-d2c206158966')
                           ,('7d001805-a58b-4158-a222-8ff30e7eb935',34,'EC','Kane Nazareth','69646300-a89c-42dc-8c79-d554afef74b0')
                           ,('838dc3ff-83c5-4dcb-ad52-c322c16cd967',42,'AR','Thurston Boustead','362e8c8e-42a1-458b-b482-3990ea06780c')
                           ,('864ced1b-3b3c-4b6c-a032-a742b96a7df4',14,'MG','Effie Althorpe','6bd9750c-4988-4b03-8270-1a4040f2dc68')
                           ,('8b268f65-48ea-4590-9414-f74a81dccbcd',45,'ID','Aloisia Rigardeau','ac2e92ed-a528-41bd-914f-6c221288319b')
                           ,('8ceda5bc-d394-4184-b061-f45541fd7c22',3,'PH','Rochelle Biagi','298f3232-84bd-428c-9e16-c9e08eb0dd2f')
                           ,('965862ff-2105-4a41-aa56-62e19c9bb4f6',39,'CN','Jorrie McTavish','2c848d9c-0b31-4db5-8d2b-e042081c6ee4')
                           ,('96854449-fb8e-40ff-81f6-1809ea884f9e',73,'US','Von Wyre','a9a85633-a565-4253-ab26-303c25684188')
                           ,('9bd59733-42ff-4558-85c5-4d06eff65690',66,'CN','Mandy Dawtre','6e517847-eee2-498c-b6cd-6a9d946b34f4')
                           ,('9f211b73-2790-408c-bb81-fba9796a7e9a',8,'CN','Darrelle Mitchelson','89b14755-d886-4096-ba1e-c11b91a2bc7d')
                           ,('a29ddc5d-12a5-4fcd-a6f8-5525ae06d498',32,'CN','Noelyn Schoroder','9696529a-eb53-46c4-8c47-6a045d8eb700')
                           ,('a2d228d0-fb81-4082-a979-3b08db046306',64,'MX','Pris Obington','08402878-f9db-4f2f-a2bc-edc40f4df369')
                           ,('a342ce4e-c375-4fcd-89be-0e75e2692b2a',61,'CD','Cecil Casari','6420df59-9252-42f1-9eff-50d0a95a544b')
                           ,('a843228f-dc50-4586-9952-26a2cb989100',49,'GR','Johna Kop','73f0badf-8b82-4838-81db-ee7161497469')
                           ,('a95fb07b-c5ff-45e1-b9d9-9a6dca50bac1',36,'GT','Land Bockings','37d8b5d3-01d2-4d87-b8a7-306ea167b5ec')
                           ,('a9c22bce-e0a9-4ef2-a8e1-ba41a357406e',34,'BR','Xylina Shave','482c24c5-811e-4cb3-8898-74748d0fb3b0')
                           ,('aad6b121-0bd6-49e0-8ee0-efef41c6574f',53,'US','Graig Rallin','6f4a4ad0-313a-4629-b773-7af5e802f52f')
                           ,('ab0ee39c-3c09-4373-9993-d38b645982a1',40,'CN','Costa Mendes','81a8f533-428f-4773-b637-fff52a31fd9e')
                           ,('b291eee3-6c28-418e-afd0-2ca0a449eae7',69,'ID','Ingaborg Richichi','147cb9c9-1aed-4628-9328-da636607da31')
                           ,('b70e2f3f-45f7-4b6a-828a-f29c967f080a',66,'CN','Malvin Millery','00534cef-a9e0-4812-959e-71124b4a4e50')
                           ,('bd4534b4-f928-442e-b8f5-843b4782749e',6,'ID','Blake Bickley','4e5f2efc-5338-40ae-8c04-b23d406ad372')
                           ,('bef04bd8-3b8e-4fad-83d5-e71e815fe92f',31,'RU','Alta Kember','6f51a99f-9a07-4ebc-b1f7-019adc23366e')
                           ,('c00790ca-9cb9-4e5f-a78b-ac4f0ed7cd99',71,'BR','Nani Bonn','b41e1328-c81b-40a3-a147-0d49f1702eef')
                           ,('c275aa2a-40d9-409b-8695-e0dfa09a8df9',59,'SE','Libbi Chastand','0e29ccd3-87bc-4f84-a12e-6088e35a867d')
                           ,('c433850f-de72-4b58-b280-3cf60e90af91',22,'JP','Brittney Lyven','026c24ab-1c76-4463-95e1-738bf404d644')
                           ,('c6209b53-fde7-4962-a504-513f49b0548d',67,'CN','Christabel Djurdjevic','678d413d-bc80-44dd-ab3d-ada92193214b')
                           ,('c664444e-ecb3-49b7-a106-f51881e79b16',35,'MN','Brod Praill','03eb43c8-6812-4b6c-9057-da7bd72b2b1a')
                           ,('c6bf142b-4bea-4293-8fcb-771b8816a23c',6,'NG','Norina Duckerin','62339472-7397-4b23-9f5d-0960b18ee6ed')
                           ,('c98d453d-701c-4700-b7e1-213334a4f6a7',44,'CN','Aundrea Dupree','3e64d0a9-2135-4ead-94a5-8768538e7919')
                           ,('cd315a3f-3df7-4a70-b761-69e77ac74229',7,'PH','Riley Lynett','8499d26e-2d62-4daf-b791-f6fe3016acf5')
                           ,('ce1ec571-3c80-400c-911c-9af03428f712',33,'PH','Zarla Pegram','a972ff17-d7a7-4cb4-ad0c-4cbdb464d2f1')
                           ,('d3e78349-75bf-4a91-8de3-3ff988d37a5e',55,'CN','Gwenni Gerardot','8bee924c-6176-4cdc-b40c-815deba18503')
                           ,('d5d655a6-f231-4fba-b5fd-4993826388af',21,'AR','Blaine Binnell','84d7a7c2-558c-4f48-94a0-d778fc99b9c0')
                           ,('d63ea9e2-4cd8-4ba8-9e11-0072fa169fb0',15,'LB','Lowell Baskerville','2d36c1dc-a12f-49ae-893c-7805b73984c8')
                           ,('d6bdf349-1652-4134-ba12-a3d813386ddb',38,'UA','Olivero Fautley','660ac374-fef1-44d1-b595-82ed8d5d1468')
                           ,('d6f6e937-aa4c-4b5f-a6e3-27cdb9ea448a',58,'ID','Eldredge Ventom','0bcda058-455d-4635-824f-bab21f8aa11e')
                           ,('dc0727d2-f59c-4496-9c5c-0e2ed7f252a0',39,'NG','Ambrosius Benny','9a673a1e-f1ac-4383-a66b-f41a4f909fb2')
                           ,('de17d067-ec25-4a70-8bb4-279de9137310',47,'CN','Frasco Lammert','a3dcfa1c-ac59-49be-b0c4-baafcd0f40cd')
                           ,('e0cae545-effe-4f43-8666-6ecf5e2547e2',17,'CN','Veronika Goldstraw','4dc3a9f8-1b43-46cc-94ee-e49d5d0af7a5')
                           ,('e29fa6f5-923a-47ed-9845-d31e53ce712a',66,'BE','Salli Cazin','16c327ae-8eba-474e-b07a-56b68db844cd')
                           ,('e2d9969a-19a1-498e-b966-ff31dfee5f08',13,'ID','Randa Duckering','3f093b98-b4df-41c6-9757-0a5c32ba8877')
                           ,('e3c88ee9-46d1-4a28-911a-862dbf625552',72,'FO','Jayme Chastan','6d0ae6e3-98a0-4b79-b00e-6b82cefa7e53')
                           ,('e652f1e9-7dd8-4de1-abfa-40e24d2241f9',38,'ZM','Stephenie Iacobo','08cdc2c1-ec5c-4372-b2a3-fdd2e5b1b91a')
                           ,('e655c3b3-0b99-4f44-b7d0-86d7eaabcb7a',11,'TH','Carlina Mallabund','2cd511d5-3a21-4ee0-b2aa-b5da4b933717')
                           ,('ea371c6e-439c-42d5-99da-6d998eb17c1c',3,'JP','Nikolas Mellanby','26ef7b8f-d190-4f54-8c57-f7c054ec6b49')
                           ,('ee04f6b8-7ef6-4515-86e9-8fa6355b4341',67,'FR','Wake McIlhatton','5a7aee62-7be0-4ab5-aea5-67c38c4f1389')
                           ,('eede47fe-3efa-4ab9-ae1e-37e3f8656fb3',12,'CA','Bucky Gow','714e94fe-2f2e-4d75-89e0-032e8362bca2')
                           ,('f51ce6f0-8021-47ac-904b-36f8b5544d5c',26,'CM','Esra Perillio','25476808-6a42-4441-88e4-9cce382539c9')
                           ,('fc261629-1167-4ce3-9b0d-3b58c98bb6b2',59,'PE','Nessy Kilvington','42507211-522a-46a5-ae7e-24eb3256d5f9')
                           ,('fea4faa9-9813-4175-8e0c-f424b8f9856c',47,'SE','Tildy Cosins','043b0df8-2c5c-4668-97d7-4ec9706d6cbf')
                           ,('ff6395e6-c856-44e7-a86f-87e98d61b60e',70,'SE','Annecorinne Humbee','7edfa79e-f318-41f0-81eb-3a5657f6c8df');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaderboards`
--

DROP TABLE IF EXISTS `leaderboards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaderboards` (
                                `leaderboard_id` varchar(255)
                                                         NOT NULL,
                                `name` varchar(255) NOT NULL,
                                `client_id` varchar(255) NOT NULL,
                                PRIMARY KEY (`leaderboard_id`),
                                KEY `FKoc3p8o59wym77o5gvh09ns2yn` (`client_id`),
                                CONSTRAINT `FKoc3p8o59wym77o5gvh09ns2yn` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaderboards`
--

LOCK TABLES `leaderboards` WRITE;
/*!40000 ALTER TABLE `leaderboards` DISABLE KEYS */;
INSERT INTO `leaderboards` VALUES ('adcf5df3-037b-4453-8187-542bd03eaca9','My first leaderboard :) ','74e95245-f20d-11ee-848a-b04f13cfd672');
/*!40000 ALTER TABLE `leaderboards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaderboards_details`
--

DROP TABLE IF EXISTS `leaderboards_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaderboards_details` (
                                        `leaderboard_details_id` varchar(255) NOT NULL,
                                        `bass_quality_quantity` varchar(5) DEFAULT NULL,
                                        `build_quality` varchar(255) DEFAULT NULL,
                                        `cable_quality` varchar(255) DEFAULT NULL,
                                        `comfort` varchar(255) DEFAULT NULL,
                                        `image_precision` tinyint DEFAULT NULL,
                                        `is_bass_head` bit(1) NOT NULL,
                                        `is_funny` bit(1) NOT NULL,
                                        `medium_bass_quality_quantity` varchar(5) DEFAULT NULL,
                                        `mid_range_quality_quantity` varchar(5) DEFAULT NULL,
                                        `monitoring_live_studio` varchar(5) DEFAULT NULL,
                                        `product_top` int NOT NULL,
                                        `sibilance_control` varchar(255) DEFAULT NULL,
                                        `sound_stage_amplitude` tinyint DEFAULT NULL,
                                        `sub_bass_quality_quantity` varchar(5) DEFAULT NULL,
                                        `treble_quality_quantity` varchar(5) DEFAULT NULL,
                                        `video_games_performance` varchar(255) DEFAULT NULL,
                                        `leaderboard_id` varchar(255) NOT NULL,
                                        `product_id` varchar(255) NOT NULL,
                                        PRIMARY KEY (`leaderboard_details_id`),
                                        KEY `FKqtkjpe483gxabyog6mmh6tctr` (`leaderboard_id`),
                                        KEY `FKm8w28i26vema6rym0sow5v98s` (`product_id`),
                                        CONSTRAINT `FKm8w28i26vema6rym0sow5v98s` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
                                        CONSTRAINT `FKqtkjpe483gxabyog6mmh6tctr` FOREIGN KEY (`leaderboard_id`) REFERENCES `leaderboards` (`leaderboard_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaderboards_details`
--

LOCK TABLES `leaderboards_details` WRITE;
/*!40000 ALTER TABLE `leaderboards_details` DISABLE KEYS */;
INSERT INTO `leaderboards_details` VALUES ('b1771889-8dc7-4de8-a8ea-c2c8dd3326fe','8/7','10','10','10',1,_binary '\0',_binary '\0','8/7','8/7','6/8',2,'8',1,'8/7','8/7','7','adcf5df3-037b-4453-8187-542bd03eaca9','63222c7d-f20d-11ee-848a-b04f13cfd672'),('b3574303-c56f-485f-8270-88f3bede3edf','8/7','10','10','10',1,_binary '\0',_binary '\0','8/7','8/7','6/8',1,'8',1,'8/7','8/7','7','adcf5df3-037b-4453-8187-542bd03eaca9','631f090d-f20d-11ee-848a-b04f13cfd672');
/*!40000 ALTER TABLE `leaderboards_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
                            `product_id` varchar(255) NOT NULL,
                            `name` varchar(50) NOT NULL,
                            `release_price` float DEFAULT NULL,
                            `website` varchar(255) DEFAULT NULL,
                            `brand_id` varchar(35) NOT NULL,
                            PRIMARY KEY (`product_id`),
                            KEY `FKa3a4mpsfdf4d2y6r8ra3sc8mv` (`brand_id`),
                            CONSTRAINT `FKa3a4mpsfdf4d2y6r8ra3sc8mv` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('631f090d-f20d-11ee-848a-b04f13cfd672','Jojo x Z reviews',NULL,NULL,'blon'),('63222c7d-f20d-11ee-848a-b04f13cfd672','Piccolo',NULL,NULL,'Tripowin');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
                           `review_number` int NOT NULL,
                           `content` text,
                           `contras` varchar(200) DEFAULT NULL,
                           `overall_rating` decimal(2,1) NOT NULL,
                           `overview` varchar(200) DEFAULT NULL,
                           `pros` varchar(200) DEFAULT NULL,
                           `review_title` varchar(45) NOT NULL,
                           `product_id` varchar(255) NOT NULL,
                           `client_id` varchar(255) NOT NULL,
                           PRIMARY KEY (`client_id`,`product_id`,`review_number`),
                           KEY `FKpl51cejpw4gy5swfar8br9ngi` (`product_id`),
                           CONSTRAINT `FKo2cmyvyjrvumg4b3de9dcvfxa` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`),
                           CONSTRAINT `FKpl51cejpw4gy5swfar8br9ngi` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
                         `user_id` varchar(255) NOT NULL,
                         `deleted` tinyint(1) NOT NULL DEFAULT '0',
                         `email` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `username` varchar(25) NOT NULL,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
                         UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('00534cef-a9e0-4812-959e-71124b4a4e50',0,'rridoutt19@lulu.com','tQ3\"{=*Qo9u\"','tdutnall19')
                         ,('025a47b6-15da-463d-89dc-7ceef1fb19de',0,'emercy25@howstuffworks.com','eZv&A*','sgoodey25')
                         ,('026c24ab-1c76-4463-95e1-738bf404d644',0,'hfinan23@chronoengine.com','bS3.<ho74','zcrossfield23')
                         ,('030be46e-d65c-4a6d-acbe-4fc74a500fcb',0,'awelden2b@yale.edu','jM4%m?Px','ematthensen2b')
                         ,('03eb43c8-6812-4b6c-9057-da7bd72b2b1a',0,'bbottrella@jimdo.com','wP\\0<VU','wboakesa')
                         ,('043b0df8-2c5c-4668-97d7-4ec9706d6cbf',0,'bmandifield21@unesco.org','oB*(&KoES','kballchin21')
                         ,('079e063b-86a5-412b-bec9-ba0e08fd825a',0,'spaulic@xinhuanet.com','wW!3o>/J2','dmilsomc')
                         ,('08402878-f9db-4f2f-a2bc-edc40f4df369',0,'vgazey2p@com.com','tIL?n\\&','adarlasson2p')
                         ,('08cdc2c1-ec5c-4372-b2a3-fdd2e5b1b91a',0,'mlemmanbie2@t-online.de','wDL/|k','ccoles2')
                         ,('0bcda058-455d-4635-824f-bab21f8aa11e',0,'dsein2e@blinklist.com','rFSKSY','croyall2e')
                         ,('0e29ccd3-87bc-4f84-a12e-6088e35a867d',0,'mwootton9@marketwatch.com','fF`iX<','kjarrad9')
                         ,('0ee16375-7e90-4361-9a49-2cd4e5d7ba36',0,'mmackeeg2a@economist.com','tTF|5pl3','hcutmare2a')
                         ,('0f180f7d-e1a7-465d-97da-77039201a57a',0,'wshotter1a@cbslocal.com','vGS7h96(','mhadgraft1a')
                         ,('0f1cb64b-3b4e-4cb6-9f60-9addcc9108d8',0,'hpendrill3@alibaba.com','jDyX#U{{pD','bdaley3')
                         ,('112966d7-f26a-4291-ae4c-43914d9bd814',0,'kduckerd@xing.com','aH{#b8qEr{Cj','mmcmurtyd')
                         ,('11bf3d46-555a-45ed-9ec0-c229dcfdac30',0,'lcodeman22@reference.com','dP4`6&,+2|E?','msholl22')
                         ,('12a2a4c7-0d3d-4fed-81c0-42f4606cc25f',0,'hferrillio2j@a8.net','zKFEA78>OJ','pnelmes2j')
                         ,('1307ed85-fc5c-4a87-9460-d2c206158966',0,'tabadam1q@telegraph.co.uk','mJ?z@+gMxn','rgreader1q')
                         ,('147cb9c9-1aed-4628-9328-da636607da31',0,'acoombesl@wisc.edu','cK7?.?0t>K8','cguenyl')
                         ,('15f36dc7-983f-4331-8258-fe22948fe059',0,'tstoop2f@dropbox.com','rCcyAUaT+{','jjessup2f')
                         ,('16c327ae-8eba-474e-b07a-56b68db844cd',0,'medgar2g@netscape.com','gX59Y2Ep1.','mprettyjohn2g')
                         ,('1986275d-4cd4-4ea4-bb20-6652b97c4581',0,'bmacnulty1i@goo.ne.jp','cDMke7}<*','tshardlow1i')
                         ,('23553a25-9c34-420b-8c21-975ccd172b02',0,'qgilks1p@accuweather.com','sT2\"fsc9Q\"','jhember1p')
                         ,('25476808-6a42-4441-88e4-9cce382539c9',0,'vberry2k@fotki.com','zB7~H\\QeOk@D','abeddard2k')
                         ,('2594f87b-9656-4ed7-b1f7-2ff2e30ac241',0,'bcattom@prlog.org','zJ0`@_|2&C=','lcosinsm')
                         ,('26ef7b8f-d190-4f54-8c57-f7c054ec6b49',0,'depdell8@nymag.com','bUvEp!c(>N','ahearmon8')
                         ,('298f3232-84bd-428c-9e16-c9e08eb0dd2f',0,'rtrevaskus17@irs.gov','nSWUD~6=}L\'','ebeetham17')
						,('2c848d9c-0b31-4db5-8d2b-e042081c6ee4',0,'mservis2m@walmart.com','sB<\'s`{95','tholmyard2m')
                         ,('2cd511d5-3a21-4ee0-b2aa-b5da4b933717',0,'rcharlick2i@theglobeandmail.com','zDdW%j','tsummerson2i')
                         ,('2d36c1dc-a12f-49ae-893c-7805b73984c8',0,'bmacrannell1p@reuters.com','tZavQxjc','ptinn1p')
                         ,('362e8c8e-42a1-458b-b482-3990ea06780c',0,'msilverwood2b@desdev.cn','oLc|V~f0c@','ebowery2b')
                         ,('37d8b5d3-01d2-4d87-b8a7-306ea167b5ec',0,'sloukesy@pinterest.com','eS5&@Z=n+=Qt','lbartholiny')
                         ,('3831a1c6-3b06-4498-b2d3-9fbd559029d7',0,'mrafferty1m@redcross.org','tOpa5Y\\h&p','jgaler1m')
                         ,('3d257a86-3318-4bfe-b8f0-d3932f89aaa7',0,'wmarnane1r@nymag.com','jZ~8gQjD.','pbliven1r')
                         ,('3dadf522-eb90-4c63-8b5a-eedaeefdf8f7',0,'hsummerbell1j@amazonaws.com','vLBQ7ve5c?','bmustoo1j')
                         ,('3e64d0a9-2135-4ead-94a5-8768538e7919',0,'scastellino1e@cocolog-nifty.com','fCx}{xgn','cmusicka1e')
                         ,('3f093b98-b4df-41c6-9757-0a5c32ba8877',0,'khenkens2a@fastcompany.com','sU9!uQ#NJ22`','lshiels2a')
                         ,('40d46332-a717-4f45-80bb-1cfdc23da856',0,'chadcockf@e-recht24.de','jWqsp?l>|','mlangrishf')
                         ,('41ba56dc-80cc-4010-8032-8ed5b4ff5854',0,'rscogin19@livejournal.com','rS22V_Y5sm|R','dgreenley19')
                         ,('42507211-522a-46a5-ae7e-24eb3256d5f9',0,'psimperq@pagesperso-orange.fr','pXm7}|tR)''p','dstickneyq')
                         ,('43fb8788-5916-4c82-bbf3-ea3452e3cd1c',0,'ghrynczyk1o@bigcartel.com','lV2=?\"{o4\"','smcclory1o')
                         ,('482c24c5-811e-4cb3-8898-74748d0fb3b0',0,'atebboth10@pcworld.com','vW5|(l=gx8Fr','vmarkie10')
                         ,('4a89894e-d214-401e-8eb1-74a379be8bd0',0,'rnorcrosse@infoseek.co.jp','vC0\\2bE8Y,F','wdellcasae')
                         ,('4b6af832-7881-4a12-94fe-d83ad9bc422f',0,'pbingham1l@addtoany.com','gKsiONc','jkenworth1l')
                         ,('4d3ca786-e8e2-4b55-88a5-a36a0810aadf',0,'gfarlambeo@bbc.co.uk','cLkf{Z&{','htomblingso')
                         ,('4dc3a9f8-1b43-46cc-94ee-e49d5d0af7a5',0,'tsarah21@amazon.co.jp','tW3<uHB#\\','ccicchelli21')
                         ,('4e5f2efc-5338-40ae-8c04-b23d406ad372',0,'lpardon2o@goodreads.com','vKFB*@!+GT<c','bbains2o')
                         ,('53c075b6-d4e7-46da-bdaa-780a7e4cd1d9',0,'bsorrie1q@hugedomains.com','kW2(p=Xg','tlinforth1q')
                         ,('5a7aee62-7be0-4ab5-aea5-67c38c4f1389',0,'rninnotti1d@dagondesign.com','sKEz1Y\"2\"','rahrens1d')
                         ,('5e1753d6-5087-4b60-b018-5b8e25eac90d',0,'nfurneauxh@auda.org.au','sXj5m0CEb8r','cdefriesh')
                         ,('615998b8-fef5-421f-b4f6-2b956810c480',0,'agettings12@elpais.com','xX3*ww1G@bL(','vgibling12')
                         ,('62339472-7397-4b23-9f5d-0960b18ee6ed',0,'hboffey14@ed.gov','gHB(Mr8q(20r','cchildren14')
                         ,('634c14f4-e9cf-4ae7-b290-16333aae74a3',0,'hfilintsev2c@google.fr','hS9>%egf5','hmeconi2c')
                         ,('6420df59-9252-42f1-9eff-50d0a95a544b',0,'ashimoni1n@bandcamp.com','lGkS/!x2','hwebland1n')
                         ,('6589acc5-f20d-11ee-848a-b04f13cfd672',0,'arizapaul987@gnail.com','12345','fatfrog')
                         ,('660ac374-fef1-44d1-b595-82ed8d5d1468',0,'gvanderstraatent@geocities.jp','wR)L|9G.!wh','owakelamt')
                         ,('678d413d-bc80-44dd-ab3d-ada92193214b',0,'afalck2r@bizjournals.com','mP3*Zd3hfd?J','cmapes2r')
                         ,('69646300-a89c-42dc-8c79-d554afef74b0',0,'mslobom1b@dmoz.org','dCN\'X','traiment1b')
                         ,('69dc991f-8aad-41c3-a8b3-b41990b3fda3',0,'kdecker29@deliciousdays.com','fNS<|>','wbrunelli29')
                         ,('6bd9750c-4988-4b03-8270-1a4040f2dc68',0,'rjoder29@github.io','oP9<$H$OwA1','cleathart29')
                         ,('6d0ae6e3-98a0-4b79-b00e-6b82cefa7e53',0,'abletsoek@weibo.com','iX8<>D9xltq','sduchesnek')
                         ,('6e517847-eee2-498c-b6cd-6a9d946b34f4',0,'amorrow7@reddit.com','fSz/_\"Cam/?Q\"','wstonehewer7')
                          ,('6f4a4ad0-313a-4629-b773-7af5e802f52f',0,'ccottey9@multiply.com','gR7)Na&6','ciacovelli9')
                          ,('6f51a99f-9a07-4ebc-b1f7-019adc23366e',0,'jthredder5@wunderground.com','jY1{ixnsv#6N','rtidman5')
                          ,('70be5165-61d8-4429-b7c4-b98bfb6af286',0,'ciwanowiczv@amazon.co.jp','pFq7|)w','npryerv')
                          ,('70d801c1-844a-4725-88e4-fb144aca1a61',0,'jsnedden2c@ovh.net','uFB}R8M$','srobbey2c')
                          ,('714e94fe-2f2e-4d75-89e0-032e8362bca2',0,'rmirando16@usnews.com','cMnczb*','hmeenan16')
                          ,('73f0badf-8b82-4838-81db-ee7161497469',0,'sraleston1o@salon.com','jF<vqy\'@S','nburchess1o')
                         ,('773728d4-b28e-4879-a25a-9cb6bc513a8b',0,'mbilliardr@businessinsider.com','dXfO/.%n5\"b.\"','pblankmanr')
                               ,('781bcc56-d1c1-4e92-b5f7-5f4bc2b59e33',0,'kshrimplinn@dyndns.org','xS`p7b','lgrimsteadn')
                               ,('7836feb5-2427-45fa-b3e0-42ab2570ca55',0,'rjanek27@mac.com','oH`Km\\M/OL','lgunston27')
                               ,('7e481393-35c0-49b9-83a0-3f6c4984a5bd',0,'pjakoz@sun.com','fKH3Z>M','tlobleyz')
                               ,('7ea110c0-a8a9-4e5c-b988-68937a2e73f4',0,'ehegertyg@friendfeed.com','iA4!5vF)A,','gfavelg')
                               ,('7edfa79e-f318-41f0-81eb-3a5657f6c8df',0,'dgeroldip@networksolutions.com','kXtf\"\'kZ\"','airdalep')
                                ,('81a8f533-428f-4773-b637-fff52a31fd9e',0,'gchaudhry1w@addtoany.com','zKN>)k','rdevonside1w')
                                ,('821c8d66-c90f-4118-a947-af0a785e7c65',0,'vwyneq@theguardian.com','zL7>O\"E+1\"','jdavissonq')
                                ,('8499d26e-2d62-4daf-b791-f6fe3016acf5',0,'wflucks1v@wunderground.com','aG7.Gi9A','kspawton1v')
                                ,('84d7a7c2-558c-4f48-94a0-d778fc99b9c0',0,'hallansu@merriam-webster.com','oG~*{6','cstonheweru')
                                ,('86fcdff1-3a28-4e61-81fd-7bb5cfe2588c',0,'kivanishchevk@foxnews.com','pCvX)c','dbiddellk')
                                ,('89b14755-d886-4096-ba1e-c11b91a2bc7d',0,'srossins@bloomberg.com','xJ8)fZeKYA','jmortimers')
                                ,('8a4af63c-42af-4866-978c-664ed7a6b87d',0,'btappor2p@gravatar.com','gZ3)cA2OkHY','kbartos2p')
                                ,('8bee924c-6176-4cdc-b40c-815deba18503',0,'emaryet1v@mail.ru','hD4(\\x\"&@<V\"','kdykas1v')
                                ,('8ca240e6-2b81-4f75-8281-cc9a82ce393e',0,'svolcker20@omniture.com','nP&+Z16QFH','iklaesson20')
                                ,('8d067791-2fb2-445e-b98e-e5905fc77184',0,'mfogdenf@biblegateway.com','cV0~K15n','jpaddefieldf')
                                ,('8f3f9d67-9b27-4ea6-8d87-2413b68972be',0,'aingliby18@ucsd.edu','vI*l_A','bantoney18')
                                ,('9125a813-2da7-400c-a1ff-9e6d32285d9a',0,'drummind@vinaora.com','tO2~s#1H','sspradberyd')
                                ,('92f000c3-bd79-47a6-b833-6e381a3e4140',0,'tgallaway1y@cam.ac.uk','nKFy%z=2Q','pfaustian1y')
                                ,('9696529a-eb53-46c4-8c47-6a045d8eb700',0,'tswinerde@cnet.com','qCHJid','rtolande')
                                ,('9a673a1e-f1ac-4383-a66b-f41a4f909fb2',0,'tbilyardl@senate.gov','zWAzd.vm1ZJ3','jashl')
                                ,('9c401a74-1742-40d2-ac01-c6b7cf10b0bc',0,'ksimonnet1x@youtu.be','kF@WpG!/cToo','llarmouth1x')
                                ,('a2a5e8f7-1304-458f-996d-bb3f90a6425a',0,'lusborn28@intel.com','vTo&nukb','kengelbrecht28')
                                ,('a3dcfa1c-ac59-49be-b0c4-baafcd0f40cd',0,'rcianni4@auda.org.au','qOLQ=`4$','gmarusic4')
                                ,('a5c5655b-fc66-41f5-a1ce-d39a4f5c26bd',0,'gcalfe2l@yahoo.com','vK!Hf5\'5>YKb','dpalffy2l')
                         ,('a972ff17-d7a7-4cb4-ad0c-4cbdb464d2f1',0,'amcgarry10@nationalgeographic.com','sYIofb','sdorant10')
                         ,('a9879a15-3867-43cb-a894-54c3f1a976f1',0,'fnorvill1h@ameblo.jp','cZ5\\BjAkF<o','baykroyd1h')
                         ,('a9a85633-a565-4253-ab26-303c25684188',0,'msharphouse0@google.de','xU5~R!>Y7>','cdodd0')
                         ,('ac2e92ed-a528-41bd-914f-6c221288319b',0,'zcorington1t@apache.org','bS787DDA,_','pocoskerry1t')
                         ,('b0b689eb-1cb1-4166-b63c-95c3a8fbb7fe',0,'cwickes23@sohu.com','zPW\'*k','fughini23')
                                ,('b41e1328-c81b-40a3-a147-0d49f1702eef',0,'jbougenj@whitehouse.gov','gIzUqqkLKt9','kwebbej')
                                ,('b424ea73-e199-488b-8e26-396be8117948',0,'ljanaszewskii@cdc.gov','nE8_y|Mzy','kmanuelii');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'iems'
--

--
-- Dumping routines for database 'iems'
--
/*!50003 DROP PROCEDURE IF EXISTS `find_leaderboard_by_id_and_order` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `find_leaderboard_by_id_and_order`(in in_leaderboard_id varchar(255), in in_custom_order varchar(4))
begin
select lbd.leaderboard_id leaderboardId, lbd.name leaderboardName, -- leaderboard info
       users.username clientUsername,/* TODO: Client Username ??? */
       product.product_id productId, product.name productName, product.brand_id productBrand,-- product details
       lbd_dtls.bass_quality_quantity bassQualityQuantity, lbd_dtls.build_quality buildQuality, -- leaderboard_details info
       lbd_dtls.cable_quality cableQuality, lbd_dtls.comfort comfort, lbd_dtls.image_precision imagePrecision,

       lbd_dtls.is_bass_head bassHead, lbd_dtls.is_funny funny,
       lbd_dtls.medium_bass_quality_quantity mediumBassQualityQuantity, lbd_dtls.mid_range_quality_quantity midRangeQualityQuantity,
       lbd_dtls.monitoring_live_studio monitoringLiveStudio, lbd_dtls.product_top productTop,
       lbd_dtls.sibilance_control sibilanceControl, lbd_dtls.sound_stage_amplitude soundStageAmplitude,
       lbd_dtls.sub_bass_quality_quantity subBassQualityQuantity,
       lbd_dtls.video_games_performance videoGamesPerformance

from leaderboards_details lbd_dtls
         inner join leaderboards lbd on lbd_dtls.leaderboard_id = lbd.leaderboard_id
         inner join products product on lbd_dtls.product_id=product.product_id
         inner join clients clients on lbd.client_id = clients.client_id
         inner join users users on clients.user_id = users.user_id

where lbd_dtls.leaderboard_id=in_leaderboard_id
order by
    case
        when in_custom_order='asc'
            then lbd_dtls.product_top end asc,
    case
        when in_custom_order='desc'
            then lbd_dtls.product_top end desc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-04 12:45:59
