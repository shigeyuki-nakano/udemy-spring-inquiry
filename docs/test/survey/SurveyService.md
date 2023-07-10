# SurveyServiceのテスト項目

## getAll

### 仕様

- アンケート一覧の取得ができること

### テスト項目

- 正常系: アンケート一覧取得処理が行われ、アンケート一覧を返却すること

## getByID

### 仕様

- 指定したIDのアンケートを取得できること

### テスト項目

- 正常系: IDを指定し実行した場合、IDを元にアンケート検索・取得処理が行われ、アンケートが返却されること
- 異常系: 指定したIDをもつアンケートが存在しなかった場合、ResourceNotFoundExceptionが投げられること

## getSatisfactionAverage

### 仕様

- アンケートの平均満足度を取得する

### テスト項目

- 正常系: アンケート一覧取得処理が行われ、それを元に集計した平均満足度が返却されること
- 準正常系: アンケート一覧取得結果が空であった場合、0が返却されること

## register

### 仕様

- アンケートの登録ができること

### テスト項目

- 正常系: 登録対象のアンケートを指定し実行した場合、アンケート登録処理が行われ、trueが返却されること

## update

- アンケートを更新できること

## テスト項目

- 正常系: 更新対象のアンケートを指定しアンケート更新を実行した場合、アンケート更新処理が行われ、trueが返却されること