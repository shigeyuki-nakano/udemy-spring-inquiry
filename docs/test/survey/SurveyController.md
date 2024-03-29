# SurveyControllerのテスト項目

## index

### 仕様

- アンケート一覧ページの取得ができること

### テスト項目

- 正常系: GETアクセスした場合、アンケート一覧取得結果を格納したモデルと満足度平均取得結果を格納したモデルが作成され、アンケート一覧ページが返却されること

## form

### 仕様

- アンケート登録ページの取得ができること

### テスト項目

- 正常系: GETアクセスした場合、アンケート登録ページの取得ができること

## formGoBack

### 仕様

- 確認ページから登録ページに内容修正のため戻ることができるようにする

### テスト項目

- 正常系: アンケートデータをPOSTした場合、アンケート登録内容を格納したモデルが作成され、アンケート登録ページの取得ができること

## updateForm

### 仕様

- アンケート更新ページの取得ができること

### テスト項目

- 正常系: IDを含んだパスにGETした場合、IDを元に取得されたアンケートを格納したモデルが作成され、アンケート登録ページの取得ができること
- 異常系: IDを含んだパスにGETしたがアンケートが見つからなかった場合、404ページを返却すること

## confirm

### 仕様

- アンケート登録内容確認ページの取得ができること
- 妥当性判定が行われること

### テスト項目

- 正常系: 登録データをPOSTした場合、アンケート登録内容を格納したモデルが作成され、アンケート登録内容確認ページが返却されること
- 異常系: 登録データの妥当性判定で失敗した場合、エラーページを返却すること

## updateConfirm

### 仕様

- アンケート更新内容確認ページの取得ができること
- 妥当性判定が行われること

### テスト項目

- 正常系: 更新データをPOSTした場合、アンケート更新内容を格納したモデルが作成され、アンケート更新内容確認ページが返却されること
- 異常系: 更新データの妥当性判定で失敗した場合、エラーページを返却すること

## complete

### 仕様

- アンケートの登録ができること
- アンケート登録された後にアンケート一覧ページにリダイレクトされること

### テスト項目

- 正常系: 登録データをPOSTした場合、アンケートの登録ができ、アンケート一覧ページにリダイレクトされること
- 異常系: アンケートの更新に失敗した場合、エラーページを返却すること

## updateComplete

### 仕様

- アンケートの更新ができること
- アンケート更新された後にアンケート一覧ページにリダイレクトされること

### テスト項目

- 正常系: 更新データをPOSTした場合、アンケートの更新ができ、アンケート一覧ページにリダイレクトされること
- 異常系: アンケートの更新に失敗した場合、エラーページを返却すること
