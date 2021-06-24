# apiTransacao
Api simula uma transação recebendo dados de compra via microservice kafka

A equipe de desenvolvimento está enviando as transações no tópico do Kafka denominado transacoes com o seguinte formato:

{
   "id":"c63fd0e0-eccb-4af3-9d49-39cde0ffdaf1",
   "valor":1.4874248222626738,
   "estabelecimento":{
      "nome":"B. A. Ware",
      "cidade":"North Winstonbury",
      "endereco":"18327 Mills Groves, West Marquita, SD 31244"
   },
   "cartao":{
      "id":"b0012b90-42c8-40e6-903b-64acb3aa649b",
      "email":"luram.archanjo@zup.com.br"
   },
   "efetivadaEm":"2020-08-10T13:16:56"
}
Para estimular a geração das transações é preciso efetuar uma requisição para o sistema bancário, conforme exemplo abaixo:

Requisição

curl --location --request POST 'http://localhost:7777/api/cartoes' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": "<NÚMERO DO CARTÃO>",
  "email": "<EMAIL DO USUÁRIO LOGADO>"
}'
Exemplo

curl --location --request POST 'http://localhost:7777/api/cartoes' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": "5541da9c-79c5-44fb-b701-cc50ed07b45d",
  "email": "xxxx@anonimo.com.br"
}'
A partir do momento do estimulo, será gerado uma transação a cada 5 minutos, caso deseja parar a geração de transação, devemos remover o mesmo do sistema bancário, conforme exemplo abaixo:

Requisição

curl --location --request DELETE 'http://localhost:7777/api/cartoes/<NÚMERO DO CARTÃO>'
Exemplo

curl --location --request DELETE 'http://localhost:7777/api/cartoes/5541da9c-79c5-44fb-b701-cc50ed07b45d'
