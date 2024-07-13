# Desafio Backend da Magalu
Confira o enunciado completo, [clique aqui](https://github.com/yhugorocha/magalums/blob/master/PROBLEM.md)
## Requisitos
### Requisitos funcionais
1. Receber uma solicitação de agendamento de envio de notificação;
2. Consultar a situação de agendamento de notificação;
3. Cancelar um agendamento de notificação;

## Solução Técnica
1. A API deverá ser Restfull;
2. Podemos utilizar qualquer linguagem (Java, Javascript, etc);
3. O banco de dados precisa ser um desses dois: (MySQL, PostgresSQL)

## Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Scheduler
- Spring Mail
- Twilio
- Lombok
- Postgres

### Arquivo json
```json
// SMS
{
  "dateTime":"2024-07-12T21:51:54",
  "destination":"+556199429****",
  "message": "Mensagem enviada via notification para o SMS",
  "channel": "SMS"
}
// WHASTAPP
{
  "dateTime":"2024-07-12T21:51:54",
  "destination":"+55619429****",
  "message": "Mensagem enviada via notification para o WPP",
  "channel": "WHATSAPP"
}
// EMAIL
{
  "dateTime":"2024-07-12T21:51:54",
  "destination":"yhugo******@gmail.com",
  "message": "Mensagem enviada via notification para o EMAIL",
  "channel": "EMAIL"
}
```






